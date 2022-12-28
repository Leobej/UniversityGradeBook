package com.can.springbootmssql.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(value = {ApiException.class})
    public static ResponseEntity<Object> handleExceptions(ApiException e) {
        logger.info("Exception handled: " + e.getMessage() + " with http status: " + e.getHttpStatus());
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
}
