package vendingmachine;

import controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        VendingMachineController machine = new VendingMachineController();
        machine.run();
    }
}
