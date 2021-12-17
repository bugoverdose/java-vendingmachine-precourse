package domain;

import static constants.SystemConstant.*;
import static utils.RandomCoinGenerator.*;

import java.util.HashMap;

public class CoinRepository {
    private static final HashMap<Coin, Integer> coins = new HashMap<>();

    public static HashMap<Coin, Integer> getCoins() { return coins; }

    public static void addCoin(Coin coin) {
        coins.put(coin, coins.get(coin)+1);
    }

    public static void subtractCoin(Coin coin, int number) {
        coins.put(coin, coins.get(coin)-number);
    }

    public static void initCoins(int vendingMachineMoney) {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }

        while (vendingMachineMoney > MINIMUM_COIN_AMOUNT) {
            Coin newCoin = pickRandomNewCoin(vendingMachineMoney);
            addCoin(newCoin);
        }
    }
}
