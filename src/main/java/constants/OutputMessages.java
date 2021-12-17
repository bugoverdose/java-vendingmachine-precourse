package constants;

import domain.Coin;

public class OutputMessages {

    public static String BLANK_LINE = "\n";

    public static String VENDING_MACHINE_COINS = "자판기가 보유한 동전" + BLANK_LINE;

    public static String COIN_NUMBER_FORMAT(Coin coin, int number) {
        return coin.getAmount() + "원 - " + number + "개" + BLANK_LINE;
    }

    public static String SHOW_CUSTOMER_MONEY_LEFT(int customerMoney) {
        return "투입 금액: " + customerMoney + "원";
    }

    public static String CHANGES = "잔돈" + BLANK_LINE;
}
