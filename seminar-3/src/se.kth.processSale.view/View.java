package se.kth.processSale.view;

import se.kth.processSale.controller.Controller;
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
        itemID2 = 123;
        itemID1 = 121;
    }

    /**
     * A hord coded sale process with three purchasing Items where two share itemID and payment with prints to Terminal
     */
    public void hardCode(){
        contr.startSale();
        contr.scanItem(itemID1);
        contr.scanItem(itemID2);
        contr.scanItem(itemID1);
        contr.endSale();
        contr.paySale(2);
        sendItemInfoToDisplay();
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
