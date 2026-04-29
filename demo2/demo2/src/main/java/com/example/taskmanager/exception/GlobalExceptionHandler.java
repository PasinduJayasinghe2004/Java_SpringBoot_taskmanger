package com.example.taskmanager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handletaskFound(TaskNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatusCode.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handleGeneral(Exception ex){
        return new ResponseEntity<>("Something wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
