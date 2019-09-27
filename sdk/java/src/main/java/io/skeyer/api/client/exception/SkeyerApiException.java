package io.skeyer.api.client.exception;

import io.skeyer.api.client.SkeyerApiError;

/**
 * An exception which can occur while invoking methods of the Skeyer API.
 */
public class SkeyerApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Skeyer API.
     */
    private SkeyerApiError error;

    /**
     * Instantiates a new Skeyer api exception.
     *
     * @param error an error response object
     */
    public SkeyerApiException(SkeyerApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Skeyer api exception.
     */
    public SkeyerApiException() {
        super();
    }

    /**
     * Instantiates a new Skeyer api exception.
     *
     * @param message the message
     */
    public SkeyerApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Skeyer api exception.
     *
     * @param cause the cause
     */
    public SkeyerApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Skeyer api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public SkeyerApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Skeyer API, or null if no response object was returned (e.g. server returned 500).
     */
    public SkeyerApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
