package se.kth.processSale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import se.kth.processSale.model.Item;
import se.kth.processSale.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale = new Sale();

    @AfterEach
    public void cleanup(){
        sale = new Sale();
    }

    @Test
    void isItemInSaleFail() {
        Item itemInSale = new Item(132,50,8,"socks",2);
        sale.addNewItemToSale(itemInSale);
        Item itemNotInSale = new Item(111,50,8,"apple",2);
        boolean itemIsInSale = sale.isItemInSale(itemNotInSale);
        assertEquals(itemIsInSale, false);
    }


    @Test
    void isItemInSaleSuccess() {
        Item itemInSale = new Item(132,50,8,"socks",2);
        sale.addNewItemToSale(itemInSale);
        Item itemNotInSale = new Item(132,50,8,"socks",1);
        boolean itemIsInSale = sale.isItemInSale(itemNotInSale);
        assertEquals(itemIsInSale, true);
    }

    @Test
    void addNewItemToSaleSuccess(){
        Item itemInSale = new Item(132,50,8,"socks",2);
        sale.addNewItemToSale(itemInSale);

        Item nextItem = new Item(sale.getItemsCurrentlyInSale()[0]);

        assertEquals(nextItem.getItemID(), itemInSale.getItemID());
    }
}