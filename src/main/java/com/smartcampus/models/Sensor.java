package com.smartcampus.models;

import java.util.List;
import java.util.ArrayList;

public class Sensor {
    private int id;  //unique ID for sensor
    private String type;  //kind of sensor
    private int roomId;  //links the sensor to a specific room
    private double currentValue;  //actual reading from the sensor
    private String status;   // status as a String

    // In-memory list of sensors
    private static List<Sensor> sensors = new ArrayList<>();

    public Sensor() {}  //default constructor needed by JAX-RS for JSON mapping

    public Sensor(int id, String type, int roomId) {
        this.id = id;
        this.type = type;
        this.roomId = roomId;
        this.status = "ACTIVE"; // default status
        this.currentValue = 0.0;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public double getCurrentValue() { return currentValue; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Static access to sensors list
    public static List<Sensor> getSensorsStatic() {
        return sensors;
    }
}
