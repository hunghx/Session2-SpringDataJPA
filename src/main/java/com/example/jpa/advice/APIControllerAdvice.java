
package com.example.jpa.advice;

import com.example.jpa.exception.DataExistException;
import com.example.jpa.model.dto.response.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class APIControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DataError<Map<String,String>> handleErr(MethodArgumentNotValidException e){
        Map<String , String> map = new HashMap<>();
        for (FieldError error : e.getFieldErrors()){
            map.put(error.getField(),error.getDefaultMessage());
        }
        return new DataError<>(map, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DataError<String> handleErrNotFound(NoSuchElementException e){
        return new DataError<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DataExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DataError<Map<String,String>> handleErrExist(DataExistException e){
        Map<String , String> map = new HashMap<>();
        map.put(e.getField(),e.getMessage());
        return new DataError<>(map, HttpStatus.BAD_REQUEST);
    }
}
