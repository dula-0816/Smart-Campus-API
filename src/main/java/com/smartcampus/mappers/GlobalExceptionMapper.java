package com.smartcampus.mappers;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {  //Intercepts the error & convert it to a clean HTTP response
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)  //Sets the HTTP code to 500
                       .entity("{\"error\":\"Internal server error occurred.\"}")  //Sets the body of the error message
                       .type(MediaType.APPLICATION_JSON)  //Tells the message is formatted as JSON
                       .build();  //Finalizes the response 
    }
}
