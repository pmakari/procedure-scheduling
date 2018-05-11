package com.caresyntax.scheduling.exception.handler;

import com.caresyntax.scheduling.exception.BeanValidationException;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parviz on 10.05.2018.
 * This class handles BeanValidationException and returns ErrorResource which contains field and message
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeanValidationExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanValidationExceptionHandler.class);

    @ExceptionHandler({BeanValidationException.class})
    protected ResponseEntity<Object> handleInvalidRequest(BeanValidationException exception, WebRequest request) {
        LOGGER.warn("BEAN VALIDATION FAILED! {}", exception.getMessage());
        List<ErrorResource> errorResources = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            ErrorResource errorResource = new ErrorResource();
            errorResource.setField(error.getField());
            errorResource.setMessage(error.getDefaultMessage());
            errorResources.add(errorResource);
        });
        //global annotations that we might used as a type level
        exception.getBindingResult().getGlobalErrors().forEach(error -> {
            ErrorResource errorResource = new ErrorResource();
            errorResource.setField("");
            errorResource.setMessage(error.getDefaultMessage());
            errorResources.add(errorResource);
        });
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, errorResources, headers, HttpStatus.BAD_REQUEST, request);
    }

    public class ErrorResource {

        private String field;
        private String message;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
