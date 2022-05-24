package se.kth.processSale.integration;

/**
 * Represents the developer log that is written to when exceptions are thrown
 */
public class DeveloperLog {
    public DeveloperLog(){}

    public void addExceptionToLog(String exceptionMessage){
        System.out.println("Developer Log:"+ exceptionMessage + "\n");
    }


}
