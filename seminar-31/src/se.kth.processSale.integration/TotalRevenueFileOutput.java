package se.kth.processSale.integration;

import se.kth.processSale.model.CustomerPaymentObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class TotalRevenueFileOutput implements CustomerPaymentObserver {
    private double totalRevenue;
    private PrintWriter logStream;

    public TotalRevenueFileOutput(){
        try{
            logStream = new PrintWriter(new FileWriter("TotalRevenue.txt"),true);
        } catch (IOException ioException) {
            System.out.println("Could not log");
            ioException.printStackTrace();
        }
    }

    @Override
    public void newPayment(double newPayment) {
        totalRevenue += newPayment;
        logStream.println("Time: " + LocalTime.now() +" | Total Current Revenue: " + totalRevenue);
    }
}
