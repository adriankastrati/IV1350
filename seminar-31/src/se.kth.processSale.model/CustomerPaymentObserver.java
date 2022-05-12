package se.kth.processSale.model;

public interface CustomerPaymentObserver {

    void newPayment(double newPayment);

}
