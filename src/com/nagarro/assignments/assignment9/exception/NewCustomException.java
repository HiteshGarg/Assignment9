package com.nagarro.assignments.assignment9.exception;

/**
 * A custom Exception class.
 *
 * @author hiteshgarg
 */
public class NewCustomException extends Exception {

    /**
     * Serial version uid of this class.
     */
    private static final long serialVersionUID = 4076611916863296393L;

    /**
     * Error message set in the custom Exception.
     */
    private final String message ;

    /**
     * Object of Exception class to hold the thrown exception object.
     */
    private final Exception exception;

    /**
     * default constructor.
     */
    public NewCustomException() {
        super();
        this.message = null;
        this.exception = null;
    }
    
    /**
     * Parameterized constructor.
     * 
     * @param message
     *            Error message.
     * @param exception
     *            Real exception object thrown at runtime.
     */
    public NewCustomException(final String message, final Exception exception) {
        super();
        this.message = message;
        this.exception = exception;
    }

    /**
     * Returns Exception object.
     *
     * @return the exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * @return message.
     */
    public String getMessage() {
        return message;
    }
}
