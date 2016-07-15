package com.cebedo.serviceasaservice;

import com.cebedo.serviceasaservice.handler.PluginHandler;
import com.cebedo.serviceasaservice.handler.RunHandler;
import com.cebedo.serviceasaservice.manager.JarManager;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 *
 * @author Vic
 */
public class Server {

    private static final int SERVER_PORT = 8080;

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Load the test Jars.
        loadTestJars();

        // Create the server.
        // Create contexts.
        // Everything else is default.
        HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
        server.createContext("/plugin", new PluginHandler());
        server.createContext("/run", new RunHandler());
        server.setExecutor(null);
        server.start();
    }

    /**
     *
     * @throws Exception
     */
    private static void loadTestJars() throws Exception {
        String jarURL = "file:///C:/Users/Vic/Documents/Vic/git/ServiceAsAService/ServiceAsAService/src/main/java/com/cebedo/serviceasaservice/sample/dist/sample.jar";
        String className = "sample.TestPlugin";
        JarManager jarManager = JarManager.getInstance();
        jarManager.loadJar(jarURL, className);
    }
}
