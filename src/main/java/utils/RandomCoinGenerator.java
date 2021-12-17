package utils;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Coin;

public class RandomCoinGenerator {

    public static Coin pickRandomNewCoin(int money) {
        while (true) {
            int randomAmount = pickRandomCoinAmount();
            if (randomAmount > money) continue;
            return Coin.getCoinByAmount(randomAmount);
        }
    }

    private static int pickRandomCoinAmount() {
        return Randoms.pickNumberInList(Coin.getCoinAmountsDescending());
    }
}
