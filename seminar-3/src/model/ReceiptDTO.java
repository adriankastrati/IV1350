package model;

public class ReceiptDTO {
    double totalVAT;
    double totalSalePrice;
    int date;
    int hourMinuteSecond;
    double change;
    String[] itemName;
    double[] itemPrice;
    double[] itemVAT;
    int[] itemQuantity;

    public ReceiptDTO(Receipt receipt){
        totalVAT = receipt.getTotalVAT();
        totalSalePrice = receipt.getTotalSalePrice();
        date = receipt.getDate();
        hourMinuteSecond = receipt.getHourMinuteSecond();
        change = receipt.getChange();
        itemName = receipt.getItemNameArray();

    }
}





