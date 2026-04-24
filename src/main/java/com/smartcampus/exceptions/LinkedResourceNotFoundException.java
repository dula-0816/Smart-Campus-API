package com.smartcampus.exceptions;

public class LinkedResourceNotFoundException extends RuntimeException {  //Making an unchecked exception
    public LinkedResourceNotFoundException(String message) {  //Allows to pass a custom error message
        super(message);  //Passes the error message up to the parent RuntimeException class
    }  
}
