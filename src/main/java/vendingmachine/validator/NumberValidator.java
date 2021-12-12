package vendingmachine.validator;

import static vendingmachine.utils.ExceptionMessages.*;

public class NumberValidator {

    public static void validateMoneyInput(String input) {
        int intInput = validateIntType(input);
        validateNotNegativeNumber(intInput);
        validateNotHaveOnesDigit(intInput);
    }

    private static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void validateNotNegativeNumber(int intInput) {
        if (intInput < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    static void validateNotHaveOnesDigit(int intInput) {
        if (intInput%10 > 0) {
            throw new IllegalArgumentException(HAS_ONES_NUMBER_EXCEPTION);
        }
    }
}
