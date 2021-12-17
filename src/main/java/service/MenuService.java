package service;

import domain.Product;
import domain.ProductRepository;

import static constants.SystemConstant.*;
import static view.InputView.requestMenuInput;

public class MenuService {

    public void run() {
        try {
            String menuInput = requestMenuInput();
            initMenu(menuInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private void initMenu(String menuInput) {
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
