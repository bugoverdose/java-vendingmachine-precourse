package controller;

import static view.InputView.*;

public class VendingMachineController {

    public void run() {
        int money = Integer.parseInt(requestVendingMachineMoneyInput());
    }
}
