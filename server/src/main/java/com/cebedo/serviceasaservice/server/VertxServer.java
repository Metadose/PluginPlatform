package com.cebedo.serviceasaservice.server;

import com.cebedo.serviceasaservice.Runner;
import com.cebedo.serviceasaservice.handler.RunHandler;
import com.cebedo.serviceasaservice.manager.JarManager;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

public class VertxServer extends AbstractVerticle {

    public static final int SERVER_PORT = 8080;

    /**
     * Convenience function to start in IDE.
     *
     * @param args
     */
    public static void main(String[] args) {
        Runner.runExample(VertxServer.class);
    }

    /**
     * Load built-in JARs.
     *
     * @throws Exception
     */
    private static void loadBuiltInJars() throws Exception {
        String jarURL = "file:///C:/Users/Vic/Documents/Vic/git/ServiceAsAService/plugin-impl/dist/plugin-impl.jar";
        String className = "com.cebedo.serviceasaservice.plugin.impl.TestPlugin";
        JarManager jarManager = JarManager.getInstance();
        jarManager.loadJar(jarURL, className);
    }

    /**
     * Start the Vert.x Server.
     */
    @Override
    public void start() {
        try {
            loadBuiltInJars();
        } catch (Exception e) {
            ;
        }

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.routeWithRegex(RunHandler.HTTP_METHOD, RunHandler.HTTP_PATH).handler(new RunHandler());
        server.requestHandler(router::accept).listen(SERVER_PORT);
    }
}
