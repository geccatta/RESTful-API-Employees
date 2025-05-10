package com.geccatta.crud_demo.errorResponse.exceptions;

public class EmployeeDoesntExist extends RuntimeException{
    public EmployeeDoesntExist(String message) {
        super(message);
    }
}
