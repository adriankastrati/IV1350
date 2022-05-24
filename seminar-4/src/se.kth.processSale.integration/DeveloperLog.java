package se.kth.processSale.integration;

/**
 * Represents the developer log that is written to when exceptions are thrown
 */
public class DeveloperLog {

    /**
     * creates a new instance of the developer log
     */
    public DeveloperLog(){}

    /**
     * Writes the Exception to the "log"( in our case the console)
     * @param exceptionMessage - message from exception
     */
    public void addExceptionToLog(String exceptionMessage){
        System.out.println("Developer Log:"+ exceptionMessage + "\n");
    }


}
