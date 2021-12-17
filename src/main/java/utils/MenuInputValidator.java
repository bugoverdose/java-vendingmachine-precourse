package utils;

import static constants.ExceptionMessages.*;
import static constants.SystemConstant.*;
import static utils.IntInputValidator.*;

import domain.ProductRepository;

public class MenuInputValidator {

    public static void validateMenuInput(String input) {
        for (String productInfo : input.split(SEMICOLON)) {
            validateProductInput(productInfo);
        }
    }

    private static void validateProductInput(String productInfo) {
        validateBrackets(productInfo);
        productInfo = productInfo.substring(1, productInfo.length()-1);

        String[] infos = productInfo.split(COMMA);
        validateThreeInfos(infos);
        validateUniqueProductName(infos[NAME_IDX]);
        validatePriceInput(infos[PRICE_IDX]);
        validateStockInput(infos[STOCK_IDX]);
    }

    private static void validateBrackets(String input) {
        if (!input.startsWith(BRACKET_LEFT) || !input.endsWith(BRACKET_RIGHT)) {
            throw new IllegalArgumentException(NO_BRACKETS_EXCEPTION);
        }
    }

    private static void validateThreeInfos(String[] infos) {
        if (infos.length != 3) {
            throw new IllegalArgumentException(NOT_THREE_INFO_EXCEPTION);
        }
    }

    private static void validateUniqueProductName(String productName) {
        if (ProductRepository.findProductByName(productName) != null) {
            throw new IllegalArgumentException(DUPLICATE_PRODUCT_NAME_EXCEPTION);
        }
    }

    private static void validatePriceInput(String priceInput) {
        validateMoneyInput(priceInput);
        validateMinimumPrice(Integer.parseInt(priceInput));
    }

    private static void validateStockInput(String stockInput) {
        int stock = validateStockIntType(stockInput);
        validateStockNotNegative(stock);
        validateMoneyNotNegative(stock);
    }

    private static int validateStockIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(STOCK_NOT_INT_TYPE_EXCEPTION);
        }
    }

    private static void validateStockNotNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(STOCK_NEGATIVE_INT_EXCEPTION);
        }
    }
}
