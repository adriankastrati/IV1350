package se.kth.processSale.view;


import se.kth.processSale.model.CustomerPaymentObserver;

public class TotalRevenueView implements CustomerPaymentObserver {
   private double totalRevenue;

   public TotalRevenueView(){
       totalRevenue = 0;
   }

    @Override
    public void newPayment(double newPayment) {
        totalRevenue += newPayment;
        printCurrentState();

    }
    private void printCurrentState(){
        System.out.println("##");
        System.out.println("Total Revenue :" + totalRevenue);
        System.out.println("##");
    }
}
