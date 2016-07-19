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
    private static final String PARAM_ARGS = "args";

    @Override
    public void handle(RoutingContext event) {
        HttpServerRequest request = event.request();
        String pluginKey = request.getParam(PARAM_KEY);
        String pluginArgs = request.getParam(PARAM_ARGS);

        String runResult = JarManager.getInstance().runJar(pluginKey, pluginArgs);

        HttpServerResponse response = event.response();
        response.putHeader("content-type", "text/html");

        String html = "";
        html += "<html>";
        html += "<body>";
        html += "<form action='/run?'>";
        html += String.format("Key: <input type='text' name='key' value='%s'/><br/>", pluginKey);
        html += String.format("Args: <input type='text' name='args' value='%s'/><br/>", request.getParam(PARAM_ARGS));
        html += "<input type='submit' value='Send'>";
        html += "</form>";
        html += "[RESULT]<br/>" + runResult;
        html += "</body>";
        html += "</html>";

        response.end(html);
    }

}
