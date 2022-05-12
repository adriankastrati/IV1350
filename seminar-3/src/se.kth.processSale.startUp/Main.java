package se.kth.processSale.startUp;


import se.kth.processSale.controller.Controller;
import se.kth.processSale.integration.AccountingSystem;
import se.kth.processSale.integration.InventorySystem;
import se.kth.processSale.integration.Printer;
import se.kth.processSale.view.View;

public class Main {
    public static void main(String[] args) {
        AccountingSystem accountSys = new AccountingSystem();
        InventorySystem inventorySys = new InventorySystem();
        Printer printer = new Printer();
        Controller contr = new Controller(accountSys, inventorySys, printer);
        View view = new View(contr);
        view.hardCode();
    }
}
