package se.kth.processSale.model;

import java.time.LocalTime;

/**
 * Represents the Data Transfer Object of a Sale
 */
public class SaleDTO {
    public LocalTime timeOfStartedSale;
    public ItemDTO[] itemsCurrentlyInSale;
    public double discount;
    public ReceiptDTO receiptDTO;
    public CustomerPaymentDTO customerPaymentDTO;

    /**
     * Creates a new instance, representing the Data Transfer Object
     * @param saleToDTO
     */
    public SaleDTO(Sale saleToDTO){
        timeOfStartedSale = saleToDTO.getTimeOfStartedSale();

        ItemDTO[] copyItemsCurrentlyInSale = new ItemDTO[saleToDTO.getItemsCurrentlyInSale().length];
        for(int i = 0; i < saleToDTO.getItemsCurrentlyInSale().length; i++){
            copyItemsCurrentlyInSale[i] = new ItemDTO(saleToDTO.getItemsCurrentlyInSale()[i]);
        }

        itemsCurrentlyInSale = copyItemsCurrentlyInSale;

        discount = saleToDTO.getDiscount();

        receiptDTO = new ReceiptDTO(saleToDTO.getReceiptForSale());

        customerPaymentDTO = new CustomerPaymentDTO(saleToDTO.getCustomerPaymentForSale());
    }



}
