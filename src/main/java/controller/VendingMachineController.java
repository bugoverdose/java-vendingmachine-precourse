package controller;

import domain.CoinRepository;
import service.ProductService;

import static view.InputView.*;
import static view.OutputView.*;

public class VendingMachineController {

    private final ProductService productService = new ProductService();

    public void run() {
        int money = Integer.parseInt(requestVendingMachineMoneyInput());
        CoinRepository.initCoins(money);
        printVendingMachineCoins();

        productService.initMenu();
    }
}
