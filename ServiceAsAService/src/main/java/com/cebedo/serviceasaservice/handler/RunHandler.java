package com.cebedo.serviceasaservice.handler;

import com.cebedo.serviceasaservice.manager.JarManager;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class RunHandler implements Handler<RoutingContext> {

    public static final HttpMethod HTTP_METHOD = HttpMethod.GET;
    public static final String HTTP_PATH = "/run";

    @Override
    public void handle(RoutingContext event) {

        // This handler will be called for every request
        HttpServerResponse response = event.response();
        response.putHeader("content-type", "text/plain");
        // String runResult = JarManager.getInstance().runJar(HTTP_PATH);

        // Write to the response and end it
        response.end("RUN HANDLER!");
    }

}
