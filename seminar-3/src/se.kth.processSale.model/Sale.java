package se.kth.processSale.model;

import java.time.LocalTime;

/**
 * Represents a Sale with different attributes
 */
public class Sale {
    private LocalTime timeOfStartedSale;
    private Item[] itemsCurrentlyInSale = new Item[0];
    private double discount;
    private Receipt receiptForSale;
    private CustomerPayment customerPaymentForSale;

    /**
     * Creates a new instance representing the different parts of a sale
     */
    public Sale(){
        this.timeOfStartedSale = LocalTime.now();
        receiptForSale = new Receipt();
        customerPaymentForSale = new CustomerPayment();
    }

    /**
     * Gets an array of the Items in the sale
     * @return the Items in Sale
     */
    public Item[] getItemsCurrentlyInSale() {
        return itemsCurrentlyInSale;
    }

    /**
     * Gets the CustomerPayment for the Sale
     * @return the CustomerPayment
     */
    public CustomerPayment getCustomerPaymentForSale() {
        return customerPaymentForSale;
    }

    /**
     * Gets discount value in sale
     * @return the double value of the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * gets Time for when the Sale was created
     * @return the time stamp of initated sale
     */
    public LocalTime getTimeOfStartedSale() {
        return timeOfStartedSale;
    }

    /**
     * Gets the Receipt created for the Sale
     * @return Receipt for sale
     */
    public Receipt getReceiptForSale() {
        return receiptForSale;
    }

    public void updateExternal(Sale saleForUpdate){
    }

    /**
     * Shows if the entered item is already in Sale
     * @param item - the Item to control
     * @return Boolean value for the item check
     */
    public boolean isItemInSale(Item item){
        boolean isItemInSale = false;

        for(Item itemSearch : itemsCurrentlyInSale){
            if(itemSearch.getItemID() == item.getItemID())
                isItemInSale = true;
        }

        return isItemInSale;
    }

    /**
     * adds new entered Item to Sale in quantity and object
     * @param itemToAddToSale - Item to add in Sale
     */
    public void addNewItemToSale(Item itemToAddToSale){
        if(isItemInSale(itemToAddToSale)){
            for(Item itemToFind : itemsCurrentlyInSale) {
                if(itemToFind.getItemID() == itemToAddToSale.getItemID()){
                    itemToFind.addToQuantity(1);
                    customerPaymentForSale.increaseAmountToPay(itemToAddToSale.getPrice() * itemToAddToSale.getQuantity());

                }
            }

        }

        else{
        Item[] itemsInSaleWithAddedItem = new Item[itemsCurrentlyInSale.length + 1];
        int i = 0;

        for(; itemsCurrentlyInSale.length > i; i++){
            itemsInSaleWithAddedItem[i] = itemsCurrentlyInSale[i];
        }

        itemsInSaleWithAddedItem[i] = itemToAddToSale;

        itemsCurrentlyInSale = itemsInSaleWithAddedItem;

        receiptForSale.addRow(itemToAddToSale);

        customerPaymentForSale.increaseAmountToPay(itemToAddToSale.getPrice()* itemToAddToSale.getQuantity());
        }
    }
}
