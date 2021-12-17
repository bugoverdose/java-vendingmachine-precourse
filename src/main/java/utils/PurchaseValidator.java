package utils;

import static constants.ExceptionMessages.*;

import domain.Product;
import domain.ProductRepository;

public class PurchaseValidator {

    public static Product returnValidProduct(String input, int customerMoney) {
        Product product = validatePurchaseNameInput(input);
        validateEnoughMoney(product, customerMoney);
        validateEnoughStock(product);
        return product;
    }

    private static Product validatePurchaseNameInput(String input) {
        Product product = ProductRepository.findProductByName(input);
        if (product == null) {
            throw new IllegalArgumentException(NOT_EXISTING_PRODUCT_EXCEPTION);
        }
        return product;
    }

    private static void validateEnoughMoney(Product product, int customerMoney) {
        if (product.getPrice() > customerMoney) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_EXCEPTION);
        }
    }

    private static void validateEnoughStock(Product product) {
        if (product.getStock() == 0) {
            throw new IllegalArgumentException(NO_STOCK_EXCEPTION);
        }
    }
}
