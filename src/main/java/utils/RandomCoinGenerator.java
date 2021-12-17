package utils;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Coin;
import domain.CoinRepository;

import static constants.SystemConstant.*;

public class RandomCoinGenerator {

    public static void generateVendingMachineCoins(int money) {
        while (money > MINIMUM_COIN_AMOUNT) {
            int newCoinAmount = pickValidNewCoinAmount(money);
            money -= newCoinAmount;
            CoinRepository.addCoin(Coin.getCoinByAmount(newCoinAmount));
        }
    }

    private static int pickValidNewCoinAmount(int money) {
        while (true) {
            int randomAmount = pickRandomCoinAmount();
            if (randomAmount > money) continue;
            return randomAmount;
        }
    }

    private static int pickRandomCoinAmount() {
        return Randoms.pickNumberInList(Coin.getCoinAmountsDescending());
    }
}
