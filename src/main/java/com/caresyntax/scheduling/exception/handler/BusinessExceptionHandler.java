package com.caresyntax.scheduling.exception.handler;

import com.caresyntax.scheduling.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * The order is specified to tell spring that first check the general exceptions
 * which are the subclasses of BusinessException and if there was no match then
 * check this handler.
 *
 * Spring MessageSource could be used here to return message if needed.
 * Created by Parviz on 10.05.2018.
 */

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler({BusinessException.class})
    protected ResponseEntity<Object> handleInvalidRequest(BusinessException exception, WebRequest request) {
        LOGGER.error("BusinessException or to be exact, DataAccessException!", exception);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> unexpectedException(Exception exception, WebRequest request) {
        LOGGER.error("UnexpectedException!", exception);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, null, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
