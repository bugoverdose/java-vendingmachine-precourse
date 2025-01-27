package vendingmachine.controller;

import static vendingmachine.constants.SystemConstants.*;

import vendingmachine.domain.Merchandise;
import vendingmachine.domain.Coin;
import vendingmachine.service.CoinService;
import vendingmachine.service.CustomerMoneyService;
import vendingmachine.service.MenuService;
import vendingmachine.view.OutputView;

import java.util.TreeMap;

public class VendingMachineController {

    private final CoinService coinService = new CoinService();
    private final MenuService menuService = new MenuService();
    private final CustomerMoneyService customerMoneyService = new CustomerMoneyService();

    public VendingMachineController() {
        coinService.initializeCoins();
        menuService.initializeMenu();
        customerMoneyService.initializeCustomerMoneyLeft();
    }

    public void run() {
        while (true) {
            int currentMoneyLeft = this.returnCurrentMoneyLeft();
            if (!menuService.hasSellableMerchandise(currentMoneyLeft)) break;
            this.sellMerchandise();
        }

        this.returnCoinChanges();
    }

    private int returnCurrentMoneyLeft() {
        int currentMoneyLeft = customerMoneyService.getCustomerMoneyLeft();
        OutputView.printMoneyLeft(currentMoneyLeft);
        return currentMoneyLeft;
    }

    private void sellMerchandise() {
        int customerMoneyLeft = customerMoneyService.getCustomerMoneyLeft();
        Merchandise merchandise = menuService.selectAvailableMerchandise(customerMoneyLeft);

        customerMoneyService.decreaseCustomerMoneyLeft(merchandise.getPrice());
        merchandise.decreaseNumber();
    }

    private void returnCoinChanges() {
        OutputView.printCoinChanges(this.calculateCoinChanges());
    }

    private TreeMap<Coin, Integer> calculateCoinChanges() {
        TreeMap<Coin, Integer> coinChanges = new TreeMap<>();
        for (Coin coin : Coin.getCoinsDesc()) {
            if (coinService.getCoins().get(coin) == ZERO_COINS) continue;
            if (customerMoneyService.getCustomerMoneyLeft() < coin.getAmount()) continue;

            int coinNumber = this.getMaximumCoinNumber(coin);
            coinChanges.put(coin, coinNumber);
            coinService.getCoins().put(coin, coinService.getCoins().get(coin)-coinNumber);
            customerMoneyService.decreaseCustomerMoneyLeft(coin.getAmount() * coinNumber);
        }
        return coinChanges;
    }

    private int getMaximumCoinNumber(Coin coin) {
        return customerMoneyService.getCustomerMoneyLeft()/coin.getAmount();
    }
}
