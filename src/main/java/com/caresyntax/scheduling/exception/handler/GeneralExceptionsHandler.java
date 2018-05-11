package com.caresyntax.scheduling.exception.handler;

import com.caresyntax.scheduling.exception.general.DuplicateResourceException;
import com.caresyntax.scheduling.exception.general.NoSuchResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * spring MessageSource could be used here to return message if needed.
 *
 * Created by Parviz on 10.05.2018.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GeneralExceptionsHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralExceptionsHandler.class);

    private MessageSource messageSource;

    @Autowired
    public GeneralExceptionsHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ExceptionHandler({DuplicateResourceException.class})
    protected ResponseEntity<Object> handleInvalidRequest(DuplicateResourceException exception, WebRequest request) {
        LOGGER.error("The resource already exists! {}", exception.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "";
        return handleExceptionInternal(exception, body, headers, HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({NoSuchResourceException.class})
    protected ResponseEntity<Object> handleNoSuchResourceException(NoSuchResourceException exception, WebRequest request) {
        LOGGER.error("The resource doesn't exist! {}", exception.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, null, headers, HttpStatus.NOT_FOUND, request);
    }
}
