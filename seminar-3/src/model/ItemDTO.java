package model;

public class ItemDTO {
    String itemID;
    double price;
    double VAT;
    String name;
    int quantity;


    public ItemDTO(String itemID, double price, double VAT, String name, int quantity){
        this.itemID = itemID;
        this.price = price;
        this.VAT = VAT;
        this.name = name;
        this.quantity = quantity;
    }

    public ItemDTO(Item item){
        this.itemID = item.getItemID();
        this.price = item.getPrice();
        this.VAT = item.getVAT();
        this.name = item.getName();
        quantity = item.getQuantity();
    }


}
