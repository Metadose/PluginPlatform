package com.cebedo.serviceasaservice.handler;

import com.cebedo.serviceasaservice.manager.JarManager;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) {
        try {
            String urlMapping = t.getRequestURI().toString();
            String response = JarManager.getInstance().runJar(urlMapping);

            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            ;
        }
    }
}
