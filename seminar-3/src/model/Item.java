package model;

public class Item {
    private String itemID;
    private double price;
    private double VAT;
    private String name;
    private int quantity;

    public Item(ItemDTO itemDTO){
        this.itemID = itemDTO.itemID;
        this.price = itemDTO.price;
        this.VAT = itemDTO.VAT;
        this.name = itemDTO.name;
    }

    public Item(String itemID, double price, double VAT, String name){
        this.itemID = itemID;
        this.price = price;
        this.VAT = VAT;
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getItemID(){
        return itemID;
    }

    public double getPrice(){
        return price;
    }

    public double getVAT(){
        return VAT;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }
}
