package se.kth.processSale.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents the Data Transfer Object of a Sale
 */
public class SaleDTO {
    public LocalTime timeOfStartedSale;
    public ArrayList<ItemDTO> itemsCurrentlyInSale = new ArrayList<>();
    public double discount;
    public ReceiptDTO receiptDTO;
    public CustomerPaymentDTO customerPaymentDTO;

    /**
     * Creates a new instance, representing the Data Transfer Object
     * @param saleToDTO
     */
    /*public SaleDTO(Sale saleToDTO){
        timeOfStartedSale = saleToDTO.getTimeOfStartedSale();

        Iterator<Item> iterator = saleToDTO.getItemsCurrentlyInSale().iterator();
        
        ArrayList<ItemDTO> copyItemsCurrentlyInSale = new ArrayList<>();

        while(iterator.hasNext()){
        Item item = iterator.next();

        ItemDTO itemDTO = new ItemDTO(item);
        copyItemsCurrentlyInSale.add(itemDTO);
        }

        discount = saleToDTO.getDiscount();

        receiptDTO = new ReceiptDTO(saleToDTO.getReceiptForSale());

        customerPaymentDTO = new CustomerPaymentDTO(saleToDTO.getCustomerPaymentForSale());
    }
     */

    public SaleDTO(Sale saleToDTO){
        this.timeOfStartedSale = saleToDTO.getTimeOfStartedSale();
        for (Item item : saleToDTO.getItemsCurrentlyInSale()) {
            this.itemsCurrentlyInSale.add(new ItemDTO(item));
        }

        this.receiptDTO = new ReceiptDTO(saleToDTO.getReceiptForSale());
        this.customerPaymentDTO = new CustomerPaymentDTO(saleToDTO.getCustomerPaymentForSale());

    }




}
