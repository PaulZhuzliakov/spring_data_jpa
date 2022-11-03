package com.zaurtregulov.spring.springboot.spring_data_jpa.exceptions_handling;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
