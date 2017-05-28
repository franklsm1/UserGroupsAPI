package com.allstate.controller;

import com.allstate.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadArgumentException(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        return new ErrorResponse(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
    }

}
