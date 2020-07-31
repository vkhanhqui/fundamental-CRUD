package com.create.demo.exceptions.controller;

import com.create.demo.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(isANullRequest.class)
    public ResponseEntity<Object> handleIsANullRequest() {
        return new ResponseEntity<>("Request is null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(isAnEmptyList.class)
    public ResponseEntity<Object> handleIsAEmptyList() {
        return new ResponseEntity<>("List is null", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FailedCreating.class)
    public ResponseEntity<Object> handleFailedCreating() {
        return new ResponseEntity<>("Could not create", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(CouldNotFind.class)
    public ResponseEntity<Object> handleCouldNotFind() {
        return new ResponseEntity<>("Could not find", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FailedDeleting.class)
    public ResponseEntity<Object> handleFailedDeleting() {
        return new ResponseEntity<>("Could not delete", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedGetting.class)
    public ResponseEntity<Object> handleFailedGetting() {
        return new ResponseEntity<>("Could not get", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedUpdating.class)
    public ResponseEntity<Object> handleFailedUpdating() {
        return new ResponseEntity<>("Could not update", HttpStatus.BAD_REQUEST);
    }

}