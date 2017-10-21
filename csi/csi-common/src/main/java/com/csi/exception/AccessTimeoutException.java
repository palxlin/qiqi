package com.csi.exception;

/**
 * Created by fanlin on 2017/10/17.
 */
public class AccessTimeoutException extends Exception {

    private static final long serialVersionUID = -7478188376528990834L;

    public AccessTimeoutException() {
    }

    public AccessTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessTimeoutException(String message) {
        super(message);
    }

    public AccessTimeoutException(Throwable cause) {
        super(cause);
    }

}
