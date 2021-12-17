package utils;

import static constants.ExceptionMessages.*;
import static constants.SystemConstant.MINIMUM_COIN_AMOUNT;
import static constants.SystemConstant.MINIMUM_PRICE;

public class IntInputValidator {

    public static void validateMoneyInput(String input) {
        int intInput = validateMoneyIntType(input);
        validateMoneyNotNegative(intInput);
        validateNoOneWon(intInput);
    }

    public static int validateMoneyIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INT_TYPE_EXCEPTION);
        }
    }

    public static void validateMoneyNotNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(NEGATIVE_INT_EXCEPTION);
        }
    }

    private static void validateNoOneWon(int input) {
        if (input%MINIMUM_COIN_AMOUNT > 0) {
            throw new IllegalArgumentException(ONE_WON_EXCEPTION);
        }
    }

    public static void validateMinimumPrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(MINIMUM_PRICE_EXCEPTION);
        }
    }
}
