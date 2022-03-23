package de_thi_c08.view;

import de_thi_c08.controller.BankController;

public class Run {
    public static void main(String[] args) {
        BankController bankController = new BankController();
        bankController.displayMainMenu();
    }
}
