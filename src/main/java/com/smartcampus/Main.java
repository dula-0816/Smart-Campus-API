package com.smartcampus;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:9091/api/v1/";

    public static HttpServer startServer() {
        // Scan packages for resources and filters
        final ResourceConfig rc = new ResourceConfig()
                .packages("com.smartcampus.resources", "com.smartcampus.mappers");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println("Server started at " + BASE_URI);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
    }
}
