package exceptions;

public class ProductDoesNotExist extends RuntimeException{
    String message = "";

    public ProductDoesNotExist (String message){
        super(message);
    }

}
