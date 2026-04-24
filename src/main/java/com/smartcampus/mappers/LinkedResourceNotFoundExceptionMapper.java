package com.smartcampus.mappers;

import com.smartcampus.exceptions.LinkedResourceNotFoundException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class LinkedResourceNotFoundExceptionMapper implements ExceptionMapper<LinkedResourceNotFoundException> {
    @Override
    public Response toResponse(LinkedResourceNotFoundException ex) {  //Converts the Java error object into an HTTP response
        return Response.status(422) // Unprocessable Entity Code
                       .entity("{\"error\":\"" + ex.getMessage() + "\"}")
                       .type(MediaType.APPLICATION_JSON)  //Make sure the header tells the client to expect JSON
                       .build();
    }
}
