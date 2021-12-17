package view;

import static constants.OutputMessages.*;

import domain.Coin;
import domain.CoinRepository;

public class OutputView {

    public static void printVendingMachineCoins() {
        StringBuilder sb = new StringBuilder();
        sb.append(VENDING_MACHINE_COINS);
        for (Coin coin : Coin.values()) {
            int number = CoinRepository.getCoins().get(coin);
            sb.append(COIN_NUMBER_FORMAT(coin, number));
        }
        sb.append(BLANK_LINE);
        System.out.println(sb);
    }

    public static void printCustomerMoneyLeft(int customerMoney) {
        System.out.println(SHOW_CUSTOMER_MONEY_LEFT(customerMoney));
    }
}