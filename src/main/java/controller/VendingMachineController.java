package controller;

import domain.CoinRepository;

import static view.InputView.*;
import static view.OutputView.*;

public class VendingMachineController {

    public void run() {
        int money = Integer.parseInt(requestVendingMachineMoneyInput());
        CoinRepository.initCoins(money);
        printVendingMachineCoins();
    }
}
