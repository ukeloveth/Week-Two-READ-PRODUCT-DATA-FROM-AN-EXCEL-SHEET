package exceptions;

public class StaffNotAuthorizedException extends RuntimeException{
    String message = "";

    public StaffNotAuthorizedException (String message) {
        this.message = message;
    }
}
