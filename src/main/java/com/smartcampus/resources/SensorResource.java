package com.smartcampus.resources;

import com.smartcampus.models.Sensor;
import com.smartcampus.models.Room;
import com.smartcampus.exceptions.LinkedResourceNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/sensors")
public class SensorResource {
    private static List<Sensor> sensors = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getSensors(@QueryParam("type") String type) {
        if (type == null || type.isEmpty()) return sensors;
        List<Sensor> filtered = new ArrayList<>();
        for (Sensor s : sensors) {
            if (s.getType().equalsIgnoreCase(type)) filtered.add(s);
        }
        return filtered;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSensor(Sensor sensor) {
        // verify room exists
        boolean roomExists = false;
        for (Room r : SensorRoom.getRoomsStatic()) {
            if (r.getId() == sensor.getRoomId()) {
                roomExists = true;
                break;
            }
        }
        if (!roomExists) {
            //Throw custom exception instead of an inline response
            throw new LinkedResourceNotFoundException("Room ID does not exist");
        }
        sensors.add(sensor);
        SensorRoom.linkSensorToRoom(sensor.getRoomId(), sensor.getType());
        return Response.status(Response.Status.CREATED).entity(sensor).build();
    }
    
    @Path("/{sensorId}/readings")
    public SensorReadingResource getSensorReadings(@PathParam("sensorId") int sensorId) {
        return new SensorReadingResource(sensorId);
    }
    
    public static List<Sensor> getSensorsStatic() {
        return sensors;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSensorById(@PathParam("id") int id) {
        for (Sensor s : sensors) {
            if (s.getId() == id) {
                return Response.ok(s).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                   .entity("{\"error\":\"Sensor not found\"}")
                   .type(MediaType.APPLICATION_JSON)
                   .build();
     }
}
    


