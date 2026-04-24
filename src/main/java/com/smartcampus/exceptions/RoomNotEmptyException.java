package com.smartcampus.exceptions;

public class RoomNotEmptyException extends RuntimeException {  //Creating an unchecked exception
    public RoomNotEmptyException(String message) {  //Constructor accepts a custom string
        super(message);  //Passes the message to the base java Exception
    }
}
