package com.geccatta.crud_demo.rest;

import com.geccatta.crud_demo.errorResponse.EmployeeErrorResponse;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeDoesntExist;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeIDModificationException;
import com.geccatta.crud_demo.errorResponse.exceptions.EmployeeNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler{

    @ExceptionHandler(EmployeeIDModificationException.class)
    public ResponseEntity<EmployeeErrorResponse> badRequestForIDModification(EmployeeIDModificationException ex){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeDoesntExist.class)
    public ResponseEntity<EmployeeErrorResponse> employeeDoesntExist(EmployeeDoesntExist ex){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<EmployeeErrorResponse> employeeNotFound(EmployeeNotFound ex){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
