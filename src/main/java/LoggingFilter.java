package com.smartcampus.mappers;  

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider  //Marker Annotation
//Allows the class to intercept incoming requests before reaching the API endpoint & Allows to intercept outgoing responses before sending to the client
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    //To write messages to the console
    private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override  //Indicating the method fulfilling the ContainerRequestFilter interface
    public void filter(ContainerRequestContext requestContext) {
        logger.info("Incoming request: " + requestContext.getMethod() + " " +   
                    requestContext.getUriInfo().getRequestUri());  //Retrieves HTTP verb
    }

    @Override  //Indicating the method fulfilling the ContainerResponseFilter interface
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        logger.info("Outgoing response: " + responseContext.getStatus());  //Retrieves HTTP status code
    }
}
