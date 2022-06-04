package se.kth.processSale.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.processSale.model.Item;
import se.kth.processSale.model.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    private Item[] itemsInDatabase;
    private InventorySystem inventorySystem = new InventorySystem();

    @BeforeEach
    void setup(){
        inventorySystem = new InventorySystem();
    }

    @Test
    void updateQuantityFromSale() {

    }

    @Test
    void getItemDTOFromDatabaseSuccess() {
        ItemDTO itemDTONotNull;
        boolean itemFound;

        itemDTONotNull = inventorySystem.getItemDTOFromDatabase(123);

        if(itemDTONotNull != null){
            itemFound = true;
        }
        else
            itemFound = false;
        assertEquals(true,itemFound);
    }

}