package service;

import domain.CoinRepository;

import static utils.IntInputValidator.validateMoneyInput;
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
            String input = requestVendingMachineMoneyInput();
            validateMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidVendingMachineMoneyInput();
        }
    }
}
