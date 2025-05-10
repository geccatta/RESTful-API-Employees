package com.geccatta.crud_demo.errorResponse.exceptions;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
