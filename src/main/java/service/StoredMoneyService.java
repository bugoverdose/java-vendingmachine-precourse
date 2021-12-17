package service;

import domain.CoinRepository;

import static view.InputView.requestVendingMachineMoneyInput;
import static view.OutputView.printVendingMachineCoins;

public class StoredMoneyService {

    public void run() {
        int money = getValidVendingMachineMoneyInput();
        CoinRepository.initCoins(money);
        printVendingMachineCoins();
    }

    private int getValidVendingMachineMoneyInput() {
        try {
            return Integer.parseInt(requestVendingMachineMoneyInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidVendingMachineMoneyInput();
        }
    }
}
