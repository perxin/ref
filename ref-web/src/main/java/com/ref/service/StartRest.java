package com.ref.service;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

import static org.apache.xmlbeans.XmlOptions.BASE_URI;

public class StartRest {

    private static StartRest instance = new StartRest();

    public static StartRest getInstance() {
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {

        StartRest handle = new StartRest();
        handle.startServer("http://127.0.0.1/ref/");

        while (true) {
            Thread.sleep(1000);
        }
    }

    private HttpServer startServer(String... url) {
        ResourceConfig rc = buildResourceConfig();
        String urlRun = url.length > 0 ? url[0] : BASE_URI;
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(urlRun), rc);
        System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", urlRun));
        return server;
    }

    private ResourceConfig buildResourceConfig() {
        final ResourceConfig rc = new ResourceConfig();
        rc.packages("com.ref.Resources");
        return rc;
    }

}
