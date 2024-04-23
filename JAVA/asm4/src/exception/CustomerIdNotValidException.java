package exception;

/**
 * Exception ném ra khi CustomerId không phù hợp
 */
public class CustomerIdNotValidException extends Exception {
    public CustomerIdNotValidException(String message) {
        super(message);
    }
}
