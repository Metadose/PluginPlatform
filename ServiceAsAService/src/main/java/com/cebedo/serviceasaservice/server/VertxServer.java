package com.cebedo.serviceasaservice.server;

import com.cebedo.serviceasaservice.Runner;
import com.cebedo.serviceasaservice.handler.RunHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class VertxServer extends AbstractVerticle {

    public static final int SERVER_PORT = 8080;

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(VertxServer.class);
    }

    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.route(RunHandler.HTTP_METHOD, RunHandler.HTTP_PATH).handler(new RunHandler());

        server.requestHandler(router::accept).listen(SERVER_PORT);
    }
}
