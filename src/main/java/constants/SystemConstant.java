package constants;

import domain.Coin;

public class SystemConstant {

    public final static String SEMICOLON = ";";
    public final static String COMMA = ",";

    public final static int MINIMUM_COIN_AMOUNT = Coin.COIN_10.getAmount();
    public final static int MINIMUM_PRICE = Coin.COIN_100.getAmount();

    public final static int NAME_IDX = 0;
    public final static int PRICE_IDX = 1;
    public final static int STOCK_IDX = 2;
}