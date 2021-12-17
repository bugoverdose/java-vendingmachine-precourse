package utils;

import static constants.ExceptionMessages.*;

import domain.Product;
import domain.ProductRepository;

public class PurchaseValidator {

    public static void validatePurchaseInput(String input) {
        Product product = validatePurchaseNameInput(input);

    }

    private static Product validatePurchaseNameInput(String input) {
        Product product = ProductRepository.findProductByName(input);
        if (product == null) {
            throw new IllegalArgumentException(NOT_EXISTING_PRODUCT);
        }
        return product;
    }
}
