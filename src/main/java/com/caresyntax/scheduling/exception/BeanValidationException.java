package com.caresyntax.scheduling.exception;

import org.springframework.validation.BindingResult;

/**
 * To be thrown when there is a validation error. Validation is done by JSR and
 * user-defined annotations. In this project, AOP will take the responsibility
 * to do so, and if there is any validation error, this exception will be thrown
 * and controllerAdvice will handle it.
 *
 * Created by Parviz on 10.05.2018.
 */
public class BeanValidationException extends RuntimeException {

    private BindingResult bindingResult;

    public BeanValidationException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }

    public BeanValidationException() {
        super();
    }

    public BeanValidationException(String message) {
        super(message);
    }

    public BeanValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
