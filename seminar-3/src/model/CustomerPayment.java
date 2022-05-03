package model;

public class CustomerPayment {
    private double customerAmount;

    public CustomerPayment(double custumerAmount){
        this.customerAmount = custumerAmount;
    }

    public void increaseAmount(double increasingAmount){
        this.customerAmount += increasingAmount;
    }

    public double getAmount(){
        return customerAmount;
    }
}


