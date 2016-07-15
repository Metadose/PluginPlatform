package com.cebedo.serviceasaservice.handler;

import com.cebedo.serviceasaservice.manager.JarManager;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class RunHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        try {
            // Trim the URL to get the JAR mapping.
            String uri = t.getRequestURI().toString();
            String urlMapping = uri.substring(4, uri.length());

            // Run the JAR.
            String response = JarManager.getInstance().runJar(urlMapping);

            // Send a response.
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            ;
        }
    }
}
