package com.smartcampus.exceptions;

public class SensorUnavailableException extends RuntimeException {
    public SensorUnavailableException(String message) {  //Describe which sensor failed
        super(message);
    }
}
