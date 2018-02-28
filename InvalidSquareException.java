/* this is an unchecked exception since squares are created by a piece's
moveFrom() method during runtime, so the exception should be capable of
catching any errors during runtime*/

/**
 * An exception that represents an invalid chess square declaration.
 *
 * @author amarino6
 * @version 1.0
 */
public class InvalidSquareException extends RuntimeException {
    /**
     * Creates a default exception with a blank message.
     */
    public InvalidSquareException() {
        super();
    }

    /**
     * Creates an exception with a specific message
     *
     * @param message a String message associated with the exception
     */
    public InvalidSquareException(String message) {
        super(message);
    }
}