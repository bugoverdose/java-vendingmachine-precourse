package service;

import domain.Coin;
import domain.CoinRepository;
import domain.Product;
import domain.ProductRepository;

import java.util.TreeMap;

import static view.InputView.*;
import static view.OutputView.printChanges;
import static view.OutputView.printCustomerMoneyLeft;

public class CustomerService {

    private int customerMoney = 0;

    public void run() {
        setCustomerMoney();

        while (hasEnoughMoney()) {
            sellProduct();
        }

        returnChanges();
    }

    private void setCustomerMoney() {
        this.customerMoney = Integer.parseInt(requestCustomerMoneyInput());
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

    private void sellProduct() {
        String productName = requestCustomerPurchaseInput();
        for (Product product : ProductRepository.getMenu()) {
            if (product.getName().equals(productName)) {
                product.decreaseStock();
                customerMoney -= product.getPrice();
            }
        }
    }

    private void returnChanges() {
        printChanges(calculateChanges());
    }

    private TreeMap<Coin, Integer> calculateChanges() {
        TreeMap<Coin, Integer> changes = new TreeMap<>();

        for (Coin coin : Coin.values()) {
            if (coin.getAmount() > customerMoney) continue;
            int coinNumber = calculateMaxCoinNumber(coin);

            changes.put(coin, coinNumber);
            customerMoney -= coin.getAmount() * coinNumber;
        }

        return changes;
    }

    private int calculateMaxCoinNumber(Coin coin) {
        int maxCoinNumber = CoinRepository.getCoins().get(coin);
        return Math.min(maxCoinNumber, customerMoney / coin.getAmount());
    }
}