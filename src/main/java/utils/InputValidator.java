package utils;

import static constants.ExceptionMessages.NOT_INT_TYPE_EXCEPTION;

public class InputValidator {

    public static void validateIntInput(String input) {
        int intInput = validateIntType(input);
    }

    public static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INT_TYPE_EXCEPTION);
        }
    }
}
