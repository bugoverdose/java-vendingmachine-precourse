package controller;

import service.CustomerService;
import service.ProductService;
import service.StoredMoneyService;

public class VendingMachineController {

    private final StoredMoneyService storedMoneyService = new StoredMoneyService();
    private final ProductService productService = new ProductService();
    private final CustomerService customerService = new CustomerService();

    public void run() {
        storedMoneyService.run();
        productService.initMenu();
        customerService.run();
    }
}
