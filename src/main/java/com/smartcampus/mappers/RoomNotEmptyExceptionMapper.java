package com.smartcampus.mappers;

import com.smartcampus.exceptions.RoomNotEmptyException;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class RoomNotEmptyExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {
    @Override
    public Response toResponse(RoomNotEmptyException ex) {
        return Response.status(Response.Status.CONFLICT) // 409 Conflict
                       .entity("{\"error\":\"" + ex.getMessage() + "\"}")
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }
}
