package utils;

import static constants.ExceptionMessages.*;
import static constants.SystemConstant.*;
import static utils.IntInputValidator.validateIntInput;

import domain.ProductRepository;

public class MenuInputValidator {

    public static void validateMenuInput(String input) {
        for (String productInfo : input.split(SEMICOLON)) {
            validateProductInput(productInfo);
        }
    }

    private static void validateProductInput(String productInfo) {
        productInfo = productInfo.substring(1, productInfo.length()-1);

        String[] infos = productInfo.split(COMMA);
        validateUniqueProductName(infos[NAME_IDX]);
        String priceInput = infos[PRICE_IDX];
        String stockInput = infos[STOCK_IDX];

        validateIntInput(priceInput);
        validateIntInput(stockInput);

        int price = Integer.parseInt(infos[PRICE_IDX]);
    }

    private static void validateUniqueProductName(String productName) {
        if (ProductRepository.findProductByName(productName) != null) {
            throw new IllegalArgumentException(DUPLICATE_PRODUCT_NAME_EXCEPTION);
        }
    }
}
