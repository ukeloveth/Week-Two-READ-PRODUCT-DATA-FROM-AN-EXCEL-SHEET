package exceptions;

public class ApplicantAlreadyExistsException extends RuntimeException{

    String message = "";

    public ApplicantAlreadyExistsException(String message){
        this.message = message;
    }
}
