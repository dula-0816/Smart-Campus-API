package com.smartcampus.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonObject;

@Path("/")   // root of /api/v1
public class DiscoveryResource {

    @GET  //HTTP GET request
    @Produces(MediaType.APPLICATION_JSON)  //Output formatted as JSON
    public String getDiscoveryInfo() {
        JsonObject json= Json.createObjectBuilder()  //Starts a builder to construct a JSON object piece by piece
                .add("version", "1.0")  //adds a key value pair for the API version
                .add("contact", "admin@westminster.ac.uk")  //adds administrative contact info
                .add("resources", Json.createObjectBuilder()  //creates a nested JSON object
                        .add("rooms", "/api/v1/rooms")
                        .add("sensors", "/api/v1/sensors")
                )
                .build();
        return json.toString();  //converts the object to a plain string
    }
}
