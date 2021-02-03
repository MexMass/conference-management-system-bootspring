package com.lukas.ramonas.cms.Exceptions;

public final class UserAlreadyExistException extends RuntimeException {

    // dont really know what serialVersionUID is for so commented out for now
//    private static final long serialVersionUID = 1L;

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }
}
