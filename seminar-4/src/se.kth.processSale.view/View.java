package se.kth.processSale.view;

import se.kth.processSale.controller.Controller;
import se.kth.processSale.exceptions.InventoryDatabaseException;
import se.kth.processSale.exceptions.MissingItemIDException;
import se.kth.processSale.model.Item;
import se.kth.processSale.model.ItemDTO;
import se.kth.processSale.model.ItemDTO;
import se.kth.processSale.model.SaleDTO;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * represent the view that a cahsier would have
 */
public class View {
    private Controller contr;
    int itemID2;
    int itemID1;

    /**
     * creates a new instance of View with method calls that starts a sale process
     * @param contr
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addCustomerPaymentObserver(new TotalRevenueView());
        itemID2 = 121;
        itemID1 = 404;
    }

    private void fetchItem(int itemID){
        try{contr.scanItem(itemID);
        } catch (MissingItemIDException missingItemID){
            System.out.println(missingItemID.getMissingItemID() + " is not a valid itemID");

        }catch (InventoryDatabaseException inventoryDatabaseDown){
            System.out.println("Server is not available");
        }
    }

    /**
     * A hord coded sale process with three purchasing Items where two share itemID and payment with prints to Terminal
     */
    public void hardCode(){

        contr.startSale();
        fetchItem(itemID1);
        fetchItem(itemID2);
        fetchItem(itemID1);
        contr.endSale();
        sendItemInfoToDisplay();
        contr.paySale(250);

        contr.startSale();
        fetchItem(itemID1);
        fetchItem(itemID1);
        fetchItem(itemID1);
        contr.endSale();
        sendItemInfoToDisplay();
        contr.paySale(300);
    }

    private void sendItemInfoToDisplay(){
        showItemsInSale(contr.getSaleDTO());
        showPriceOfItemsInSale(contr.getSaleDTO());
        showQuantityOfItemsInSale(contr.getSaleDTO());
        showPrice(contr.getSaleDTO());
    }

    public void showItemsInSale(SaleDTO saleDTO){
        System.out.println("Items in sale:");

        for(ItemDTO item : saleDTO.itemsCurrentlyInSale)
            System.out.println(item.name);

    }



    public void showPriceOfItemsInSale(SaleDTO saleDTO){
        System.out.println("Price of items in sale:");
        for(ItemDTO itemDTO : saleDTO.itemsCurrentlyInSale)
        {
            System.out.println(itemDTO.price);
        }
    }

    public void showQuantityOfItemsInSale(SaleDTO saleDTO){
        System.out.println("Quantity of items in sale:");
        for(ItemDTO itemDTO : saleDTO.itemsCurrentlyInSale){
            System.out.println(itemDTO.quantity);
        }
    }

    public void showPrice(SaleDTO saleDTO){
        System.out.println("Price of items in sale:"+ saleDTO.customerPaymentDTO.amountToPay);
    }
}
