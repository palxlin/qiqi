package com.csi.exception;

/**
 * Created by fanlin on 2017/10/11.
 */
public class CsiException extends Exception {

    private static final long serialVersionUID = 6034592482590653805L;

    public CsiException() {
        super();
    }

    public CsiException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsiException(String message) {
        super(message);
    }

    public CsiException(Throwable cause) {
        super(cause);
    }
}
