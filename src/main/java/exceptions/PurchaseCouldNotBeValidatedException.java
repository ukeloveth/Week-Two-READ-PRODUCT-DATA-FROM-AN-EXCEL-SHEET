package exceptions;

public class PurchaseCouldNotBeValidatedException extends RuntimeException{
    String message = "";

    public PurchaseCouldNotBeValidatedException (String message) {
        this.message = message;
    }
}
