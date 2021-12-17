package controller;

import service.CustomerService;
import service.MenuService;
import service.StoredMoneyService;

public class VendingMachineController {

    private final StoredMoneyService storedMoneyService = new StoredMoneyService();
    private final MenuService menuService = new MenuService();
    private final CustomerService customerService = new CustomerService();

    public void run() {
        storedMoneyService.run();
        menuService.run();
        customerService.run();
    }
}
