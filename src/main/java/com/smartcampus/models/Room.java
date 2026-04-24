package com.smartcampus.models;

public class Room {
    private int id;  //unique identifier for the room
    private String name;  //human-readable name
    private int capacity;  //maximum no of people/devices the room can hold

    public Room() {}

    public Room(int id, String name, int capacity) {  //allows to create & populate a room object in one line of code
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    //Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
