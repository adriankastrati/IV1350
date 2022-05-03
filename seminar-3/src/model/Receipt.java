package model;

public class Receipt {
    private double totalVAT;
    private double totalSalePrice;
    private int date;
    private int hourMinuteSecond;
    private double change;
    private String[] itemName;
    private double[] itemPrice;
    private double[] itemVAT;
    private int[] itemQuantity;
    private int receiptRowPosition = 0;

    public Receipt(int dateOnReceipt, int hourMinuteSecondOnReceipt){
        this.date = date;
        this.hourMinuteSecond = hourMinuteSecond;
    }

    public void setChange(double saleChange){
        change = saleChange;
    }

    public double getChange() {
        return change;
    }

    public String getItemNameByElement(int elementInItemList){
        return itemName[elementInItemList];
    }

    public double[] getItemPrice() {
        return itemPrice;
    }

    public double getItemVAT(int elementInItemList) {
        return itemVAT[elementInItemList];
    }

    public double[] itemPriceArray(){
        return itemPrice;
    }

    public String[] getItemNameArray() {
        return itemName;
    }

    public int[] itemVATArray(){
        return itemVAT;
    }

    public double getTotalVAT(){
        return totalVAT;
    }

    public double getTotalSalePrice(){
        return totalSalePrice;
    }

    public int getDate() {
        return date;
    }

    public int getHourMinuteSecond(){
        return hourMinuteSecond;
    }


    public void addRow(ItemDTO itemToBeAddedOnReceipt){
        totalVAT += itemToBeAddedOnReceipt.VAT;
        totalSalePrice += itemToBeAddedOnReceipt.price;
        itemName[receiptRowPosition] = itemToBeAddedOnReceipt.name;
        itemPrice[receiptRowPosition] = itemToBeAddedOnReceipt.price;
        itemVAT[receiptRowPosition] = itemToBeAddedOnReceipt.VAT;
        itemQuantity[receiptRowPosition] = itemToBeAddedOnReceipt.quantity;
        receiptRowPosition++;
    }
}


