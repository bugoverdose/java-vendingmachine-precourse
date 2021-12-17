package service;

import static utils.IntInputValidator.validateMoneyInput;
import static utils.PurchaseValidator.*;
import static view.InputView.*;
import static view.OutputView.printChanges;
import static view.OutputView.printCustomerMoneyLeft;

import domain.Coin;
import domain.CoinRepository;
import domain.Product;
import domain.ProductRepository;

import java.util.TreeMap;

public class CustomerService {

    private int customerMoney = 0;

    public void run() {
        setCustomerMoney();

        while (hasEnoughMoney()) {
            getPurchaseInput();
        }

        returnChanges();
    }

    private void setCustomerMoney() {
        this.customerMoney = getValidCustomerMoneyInput();
    }

    private int getValidCustomerMoneyInput() {
        try {
            String input = requestCustomerMoneyInput();
            validateMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidCustomerMoneyInput();
        }
    }

    private boolean hasEnoughMoney() {
        printCustomerMoneyLeft(customerMoney);

        for (Product product : ProductRepository.getMenu()) {
            if (product.getStock() == 0) continue;
            if (product.getPrice() > customerMoney) continue;
            return true;
        }
        return false;
    }

    private void getPurchaseInput() {
        try {
            sellProduct();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPurchaseInput();
        }
    }

    private void sellProduct() {
        String productName = requestCustomerPurchaseInput();
        Product product = returnValidProduct(productName, customerMoney);
        product.decreaseStock();
        customerMoney -= product.getPrice();
    }

    private void returnChanges() {
        printChanges(calculateChanges());
    }

    private TreeMap<Coin, Integer> calculateChanges() {
        TreeMap<Coin, Integer> changes = new TreeMap<>();

        for (Coin coin : Coin.values()) {
            if (coin.getAmount() > customerMoney) continue;
            int coinNumber = calculateMaxCoinNumber(coin);
            if (coinNumber == 0) continue;

            changes.put(coin, coinNumber);
            customerMoney -= coin.getAmount() * coinNumber;
            CoinRepository.subtractCoin(coin, coinNumber);
        }

        return changes;
    }

    private int calculateMaxCoinNumber(Coin coin) {
        int maxCoinNumber = CoinRepository.getCoins().get(coin);
        return Math.min(maxCoinNumber, customerMoney / coin.getAmount());
    }
}