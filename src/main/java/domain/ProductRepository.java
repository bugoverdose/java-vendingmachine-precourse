package domain;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> menu = new ArrayList<>();

    public static List<Product> getMenu() { return menu; }

    public static void addProduct(Product product) {
        menu.add(product);
    }
}
