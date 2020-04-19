package pl.paw.calc.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
