package view;

import static constants.InputMessages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestVendingMachineMoneyInput() {
        System.out.println(REQUEST_VENDING_MACHINE_MONEY_INPUT);
        return Console.readLine();
    }

    public static String requestMenuInput() {
        System.out.println(REQUEST_MENU_INPUT);
        return Console.readLine();
    }

    public static String requestCustomerMoneyInput() {
        System.out.println(REQUEST_CUSTOMER_MONEY_INPUT);
        return Console.readLine();
    }

    public static String requestCustomerPurchaseInput() {
        System.out.println(REQUEST_PRODUCT_NAME_INPUT);
        return Console.readLine();
    }
}
