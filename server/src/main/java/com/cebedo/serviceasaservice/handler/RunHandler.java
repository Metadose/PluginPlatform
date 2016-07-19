package com.cebedo.serviceasaservice.handler;

import com.cebedo.serviceasaservice.manager.JarManager;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class RunHandler implements Handler<RoutingContext> {

    public static final HttpMethod HTTP_METHOD = HttpMethod.GET;
    public static final String HTTP_PATH = "/run.*";

    private static final String PARAM_KEY = "key";

    @Override
    public void handle(RoutingContext event) {
        HttpServerRequest request = event.request();
        String pluginKey = request.getParam(PARAM_KEY);
        String runResult = JarManager.getInstance().runJar(pluginKey);

        HttpServerResponse response = event.response();
        response.putHeader("content-type", "text/plain");
        response.end(runResult);
    }

}
