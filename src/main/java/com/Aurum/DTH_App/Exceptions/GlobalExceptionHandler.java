package com.Aurum.DTH_App.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Something Went Wrong.");
        errorResponse.put("message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

