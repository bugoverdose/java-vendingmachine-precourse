package view;

import static constants.InputMessages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestVendingMachineMoneyInput() {
        System.out.println(REQUEST_VENDING_MACHINE_MONEY_INPUT);
        return Console.readLine();
    }
}
