package se.kth.processSale.integration;

import se.kth.processSale.model.Item;
import se.kth.processSale.model.ItemDTO;
import se.kth.processSale.model.SaleDTO;

public class InventorySystem{
    private Item[] itemsInDatabase = {new Item(121,150,30,"Pear", 3), new Item(123,10,3.33,"Avacado", 3)};

    public InventorySystem(){
    }

    public void updateQuantityFromSale(SaleDTO proccessedSale){
    }

    public ItemDTO getItemDTOFromDatabase(int itemID){
        Item itemToReturn = null;

        for(Item item : itemsInDatabase) {
            if(item.getItemID() == itemID){
                itemToReturn = item;
            }
        }
        
        return new ItemDTO(itemToReturn);
    }

}
