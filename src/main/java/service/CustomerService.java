package service;

import domain.Product;
import domain.ProductRepository;

import static view.InputView.*;

public class CustomerService {

    private int customerMoney = 0;

    public void run() {
        setCustomerMoney();
    }

    private void setCustomerMoney() {
        this.customerMoney = Integer.parseInt(requestCustomerMoneyInput());
    }

    private boolean hasEnoughMoney() {
        for (Product product : ProductRepository.getMenu()) {
            if (product.getStock() == 0) continue;
            if (product.getPrice() > customerMoney) continue;
            return true;
        }
        return false;
    }
}
