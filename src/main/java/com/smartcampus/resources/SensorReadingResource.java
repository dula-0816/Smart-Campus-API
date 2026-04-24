package com.smartcampus.resources;

import com.smartcampus.models.Sensor;
import com.smartcampus.models.SensorReading;
import com.smartcampus.exceptions.SensorUnavailableException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

public class SensorReadingResource {
    private int sensorId;
    private static Map<Integer, List<SensorReading>> readings = new HashMap<>();

    public SensorReadingResource(int sensorId) {
        this.sensorId = sensorId;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorReading> getReadings() {
        return readings.getOrDefault(sensorId, new ArrayList<>());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReading(SensorReading reading) {

        // update currentValue on parent Sensor
        for (Sensor s : SensorResource.getSensorsStatic()) {
            if (s.getId() == sensorId) {
                if (s.getStatus() != null && s.getStatus().equalsIgnoreCase("MAINTENANCE")) {
                    throw new SensorUnavailableException("Sensor in maintenance mode.");
                }

                s.setCurrentValue(reading.getValue());
                break;
            }
        }
        
        readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(reading);

        return Response.status(Response.Status.CREATED).entity(reading).build();
    }
}

