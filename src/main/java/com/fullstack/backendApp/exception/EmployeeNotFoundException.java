package com.fullstack.backendApp.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id){
        super("Could not found employee with id "+id);
    }
}
