package com.caresyntax.scheduling.exception.general;


import com.caresyntax.scheduling.exception.BusinessException;

/**
 * Created by Parviz on 10.05.2018.
 * Whenever the desired entity does not exists  in the DB, this exception should be thrown
 */
public class NoSuchResourceException extends BusinessException {

    public NoSuchResourceException(String message) {
        super(message);
    }

    public NoSuchResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
