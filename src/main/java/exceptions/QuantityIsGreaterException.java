package exceptions;

public class QuantityIsGreaterException extends RuntimeException{
    String message = "";

    public QuantityIsGreaterException (String message) {
        this.message = message;
    }
}
