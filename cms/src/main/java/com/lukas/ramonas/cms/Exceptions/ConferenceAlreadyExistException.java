package com.lukas.ramonas.cms.Exceptions;

public final class ConferenceAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 5861310537366287163L;

    public ConferenceAlreadyExistException() {
        super();
    }

    public ConferenceAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConferenceAlreadyExistException(final String message) {
        super(message);
    }

    public ConferenceAlreadyExistException(final Throwable cause) {
        super(cause);
    }
}
