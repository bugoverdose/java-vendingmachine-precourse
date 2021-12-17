package service;

import domain.Product;
import domain.ProductRepository;

import static constants.SystemConstant.*;
import static view.InputView.requestMenuInput;

public class ProductService {

    public void initMenu() {
        String menuInput = requestMenuInput();
        for (String productInfos : menuInput.split(SEMICOLON)) {
            productInfos = productInfos.substring(1, productInfos.length()-1);

            String[] infos = productInfos.split(COMMA);
            String name = infos[NAME_IDX];
            int price = Integer.parseInt(infos[PRICE_IDX]);
            int stock = Integer.parseInt(infos[STOCK_IDX]);
            ProductRepository.addProduct(new Product(name, price, stock));
        }
    }
}
