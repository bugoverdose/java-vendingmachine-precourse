package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.HashMap;

public class VendingMachine {

    private final HashMap<Coin, Integer> coins = new HashMap<>();
    private Menu menu;
    private int moneyLeft = 0;

    public VendingMachine() {
        int totalMoney = InputView.getVendingMachineTotalMoneyInput();
        this.initializeCoins(totalMoney);
        OutputView.printCoinsInfo(this.coins);
        this.setMenu(InputView.getMenuInput());
        this.setMoneyLeft(InputView.getCustomerMoneyInput());
    }

    public void run() {
        while (true) {
            OutputView.printMoneyLeft(this.getMoneyLeft());

            if (!menu.canBuyMore(this.moneyLeft)) break;
            this.sellMerchandise();
        }

        OutputView.printCoinChanges(this.calculateCoinChanges());
    }

    private void initializeCoins(int totalMoney) {
        for (Coin coin : Coin.values()) {
            this.coins.put(coin, 0);
        }
        generateCoins(totalMoney);
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > 0) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmountDesc());
            if (totalMoney >= randomCoinAmount) {
                Coin newCoin = Coin.getCoinByAmount(randomCoinAmount);
                coins.put(newCoin, coins.get(newCoin) + 1);
                totalMoney -= randomCoinAmount;
            }
        }
    }

    private void setMenu(Menu menu) {
        this.menu = menu;
    }

    private int getMoneyLeft() {
        return this.moneyLeft;
    }

    private void setMoneyLeft(int moneyInput) {
        this.moneyLeft = moneyInput;
    }

    private void sellMerchandise() {
        String name = InputView.getMerchandiseNameInput();
        Merchandise merchandise = menu.getMerchandiseByName(name);

        if (merchandise.getNumber() == 0) throw new IllegalArgumentException();

        moneyLeft -= merchandise.getPrice();
        merchandise.decreaseNumber();
    }

    private HashMap<Coin, Integer> calculateCoinChanges() {
        HashMap<Coin, Integer> coinChanges = new HashMap<>();
        for (Coin coin : Coin.getCoinsDesc()) {
            if (this.coins.get(coin) == 0) continue;
            if (this.moneyLeft < coin.getAmount()) continue;
            int spentCoinNumber = this.moneyLeft/coin.getAmount();
            if (spentCoinNumber > this.coins.get(coin)) {
                spentCoinNumber = this.coins.get(coin);
            }
            coinChanges.put(coin, spentCoinNumber);
            this.coins.put(coin, this.coins.get(coin)-spentCoinNumber);
            this.moneyLeft -= coin.getAmount() * spentCoinNumber;
        }
        return coinChanges;
    }
}
