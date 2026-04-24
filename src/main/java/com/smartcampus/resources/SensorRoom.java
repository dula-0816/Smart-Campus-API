package com.smartcampus.resources;

import com.smartcampus.models.Room;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.smartcampus.exceptions.RoomNotEmptyException;
import javax.ws.rs.ext.Provider;
import java.util.*;

@Path("/rooms")
public class SensorRoom {
    // In-memory storage
    private static List<Room> rooms = new ArrayList<>();

    // Track sensors assigned to each room
    private static Map<Integer, List<String>> roomSensors = new HashMap<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getRooms() {
        return rooms;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(Room room) {
        rooms.add(room);
        roomSensors.put(room.getId(), new ArrayList<>()); // initialize sensor list
        return Response.status(Response.Status.CREATED).entity(room).build();
    }

    @GET
    @Path("/{roomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoom(@PathParam("roomId") int roomId) {
        for (Room r : rooms) {
            if (r.getId() == roomId) {
                return Response.ok(r).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{roomId}")
    public Response deleteRoom(@PathParam("roomId") int roomId) {
        List<String> sensors = roomSensors.get(roomId);
        if (sensors != null && !sensors.isEmpty()) {
            //Throw custom exception instead of an inline response
            throw new RoomNotEmptyException("Room cannot be deleted while sensors are active");
        }

        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room r = iterator.next();
            if (r.getId() == roomId) {
                iterator.remove();
                roomSensors.remove(roomId);
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    public static List<Room> getRoomsStatic() {
        return rooms;
    }

    public static void linkSensorToRoom(int roomId, String sensorType) {
        roomSensors.computeIfAbsent(roomId, k -> new ArrayList<>()).add(sensorType);
    }
} 

