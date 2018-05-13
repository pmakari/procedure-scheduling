package com.caresyntax.scheduling.exception.specific;


import com.caresyntax.scheduling.exception.general.NoSuchResourceException;

/**
 *
 * Created by Parviz on 10.05.2018.
 */
public class NoSuchStudyException extends NoSuchResourceException {

    public NoSuchStudyException(String message) {
        super(message);
    }

    public NoSuchStudyException(String message, Throwable cause) {
        super(message, cause);
    }

}
