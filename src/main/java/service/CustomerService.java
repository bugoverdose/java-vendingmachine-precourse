package service;

import static view.InputView.*;

public class CustomerService {

    private int customerMoney = 0;

    public void setCustomerMoney() {
        this.customerMoney = Integer.parseInt(requestCustomerMoneyInput());
    }
}
