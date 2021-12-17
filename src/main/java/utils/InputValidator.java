package utils;

import static constants.ExceptionMessages.*;

public class InputValidator {

    public static void validateIntInput(String input) {
        int intInput = validateIntType(input);
        validateNotNegative(intInput);
    }

    private static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INT_TYPE_EXCEPTION);
        }
    }

    private static void validateNotNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(NEGATIVE_INT_EXCEPTION);
        }
    }
}
