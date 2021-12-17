package service;

import domain.Product;
import domain.ProductRepository;

import static view.InputView.requestMenuInput;

public class ProductService {

    public void initMenu() {
        String menuInput = requestMenuInput();
        for (String productInfos : menuInput.split(";")) {
            productInfos = productInfos.substring(1, productInfos.length()-1);

            String[] infos = productInfos.split(",");
            String name = infos[0];
            int price = Integer.parseInt(infos[1]);
            int stock = Integer.parseInt(infos[2]);
            ProductRepository.addProduct(new Product(name, price, stock));
        }
    }
}
