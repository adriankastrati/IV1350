package se.kth.processSale.integration;

import se.kth.processSale.exceptions.InventoryDatabaseException;
import se.kth.processSale.exceptions.MissingItemIDException;
import se.kth.processSale.model.Item;
import se.kth.processSale.model.ItemDTO;
import se.kth.processSale.model.SaleDTO;

public class InventorySystem{
    private Item[] itemsInDatabase = {new Item(121,100,30,"Pear", 3), new Item(123,10,3.33,"Avacado", 3)};

    private final int serverDownItemID = 404;

    public int getServerDownItemID() {
        return serverDownItemID;
    }

    public void updateQuantityFromSale(SaleDTO proccessedSale){
    }

    public ItemDTO getItemDTOFromDatabase(int itemID) throws MissingItemIDException, InventoryDatabaseException{
        if(itemID == 404){
            throw new InventoryDatabaseException();
        }

        Item itemToReturn = null;

        for(Item item : itemsInDatabase) {
            if(item.getItemID() == itemID){
                itemToReturn = item;
            }
        }

        if(itemToReturn == null){
            throw new MissingItemIDException(itemID);
        }

        return new ItemDTO(itemToReturn);
    }

}
