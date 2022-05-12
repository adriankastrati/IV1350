package se.kth.processSale.exceptions;

/**
 * Represents an exception for when an invalid amount of an item is given
 */
public class InvalidAmountException extends RuntimeException{

    private int invalidAmount;

    InvalidAmountException(int invalidAmount){
        super("Given amount" + invalidAmount + "for item is invalid");
        this.invalidAmount = invalidAmount;
    }

    public int getInvalidAmount() {
        return invalidAmount;
    }
}
