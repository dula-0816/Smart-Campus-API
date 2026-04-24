package com.smartcampus.mappers;

import com.smartcampus.exceptions.SensorUnavailableException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class SensorUnavailableExceptionMapper implements ExceptionMapper<SensorUnavailableException> {
    @Override
    public Response toResponse(SensorUnavailableException ex) {
        return Response.status(Response.Status.FORBIDDEN) // 403 Forbidden
                       .entity("{\"error\":\"" + ex.getMessage() + "\"}")
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
