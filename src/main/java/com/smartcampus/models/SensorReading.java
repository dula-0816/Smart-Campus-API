package com.smartcampus.models;

import java.time.LocalDateTime;

public class SensorReading {
    private int id;  //uniques ID of the sensor which generated data
    private double value;  //numeric measurement recorded
    private LocalDateTime timestamp;  //exact date & time the measurement was taken

    public SensorReading() {}

    public SensorReading(int id, double value, LocalDateTime timestamp) {  //allows to create a record quickly
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
