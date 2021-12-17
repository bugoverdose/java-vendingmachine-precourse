package service;

import domain.Product;
import domain.ProductRepository;

import static constants.OutputMessages.SHOW_CUSTOMER_MONEY_LEFT;
import static view.InputView.*;
import static view.OutputView.printCustomerMoneyLeft;

public class CustomerService {

    private int customerMoney = 0;

    public void run() {
        setCustomerMoney();

        while (hasEnoughMoney()) {

        }
    }

    private void setCustomerMoney() {
        this.customerMoney = Integer.parseInt(requestCustomerMoneyInput());
    }

    private boolean hasEnoughMoney() {
        printCustomerMoneyLeft(customerMoney);

        for (Product product : ProductRepository.getMenu()) {
            if (product.getStock() == 0) continue;
            if (product.getPrice() > customerMoney) continue;
            return true;
        }
        return false;
    }
}
