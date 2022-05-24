package se.kth.processSale.controller;

import se.kth.processSale.exceptions.InventoryDatabaseException;
import se.kth.processSale.exceptions.MissingItemIDException;
import se.kth.processSale.integration.AccountingSystem;
import se.kth.processSale.integration.InventorySystem;
import se.kth.processSale.integration.Printer;
import se.kth.processSale.model.CustomerPaymentObserver;
import se.kth.processSale.model.Item;
import se.kth.processSale.model.ItemDTO;
import se.kth.processSale.model.ReceiptDTO;
import se.kth.processSale.model.Sale;
import se.kth.processSale.model.SaleDTO;
import se.kth.processSale.integration.TotalRevenueFileOutput;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Controller for integration and model layer
 */
public class Controller {
    private AccountingSystem accountSysController;
    private InventorySystem inventorySystemController;
    private Printer printerController;
    private Sale saleController;
    private List<CustomerPaymentObserver> customerPaymentObservers = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();

    /**
     * Creates a new instance of Controller
     * @param accountSys
     * @param invSys
     * @param printer
     */
    public Controller(AccountingSystem accountSys, InventorySystem invSys, Printer printer){
        accountSysController = accountSys;
        inventorySystemController = invSys;
        printerController = printer;
    }

    public void linkAccountingSystemToController(AccountingSystem AccSysToBeLinked){
        accountSysController = AccSysToBeLinked;

    }
    public void linkInventorySystemToController(InventorySystem inventorySystemToBeLinked){
        inventorySystemController = inventorySystemToBeLinked;
    }

    /**
     * Adds new an observer for CustomerPayment class to the controller
     * @param customerPaymentObserver - the observer to be added
     */
    public void addCustomerPaymentObserver(CustomerPaymentObserver customerPaymentObserver){
        customerPaymentObservers.add(customerPaymentObserver);
    }

    public void linkPrinterToController(Printer printerToBeLinked){
        printerController = printerToBeLinked;
    }

    public void linkSaleToController(Sale SaleToBeLinked){
        saleController = SaleToBeLinked;
    }

    /**
     * Adds Item found in <code> InventorySystem </code> connected by <code> itemID </code> to <code>Sale</code>
     * @param itemID
     */
    public void scanItem(int itemID){
        ItemDTO itemDTOFromDatabase = null;

        try {
           itemDTOFromDatabase = inventorySystemController.getItemDTOFromDatabase(itemID);
       } catch (MissingItemIDException missingItemID){
           System.out.println(missingItemID.getMissingItemID() + " is not a valid itemID");
           return;
       }
        catch (InventoryDatabaseException inventoryDatabaseDown){
            System.out.println("Server is not available");
            return;
        }


        Item itemFromDatabase = new Item(itemDTOFromDatabase);

        itemFromDatabase.addToQuantity(1);

        saleController.addNewItemToSale(itemFromDatabase);
    }

    /**
     * Starts a new <code>Sale</code> and links it to controller
     */
    public void startSale () {
        saleController = new Sale();
        saleController.getCustomerPaymentForSale().addCustomerPaymentObservers(customerPaymentObservers);
        saleController.getCustomerPaymentForSale().setTotalRevenueFileOutput(totalRevenueFileOutput);
    }

    /**
     * Ends <code>Sale</code> by updating external systems with current <code>Sale</code>
     */
    public void endSale(){
        SaleDTO saleDTO = new SaleDTO(saleController);
        inventorySystemController.updateQuantityFromSale(saleDTO);
        accountSysController.update(saleDTO);
    }

    /**
     * Payment for <code>Sale</code> by amount and returning change
     * @param payment - Given for payment
     * @return Amount exceeding <code>PaymentAmount</code> for current <code>Sale</code>
     */
    public double paySale(double payment){
        saleController.getCustomerPaymentForSale().payAmount(payment);
        return saleController.getCustomerPaymentForSale().getChange();
    }

    /**
     * Get <code>SaleDTO</code> for current <code>Sale</code> linked to <code>Controller</code>
     * @return - data transfer object for <code>Sale</code>
     */
    public SaleDTO getSaleDTO(){
        SaleDTO saleDTO = new SaleDTO(saleController);
        return saleDTO;
    }

    public ReceiptDTO printReceipt(){
    return new ReceiptDTO(saleController.getReceiptForSale());
    }
}
