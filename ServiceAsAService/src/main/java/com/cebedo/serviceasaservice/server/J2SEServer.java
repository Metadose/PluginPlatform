package com.cebedo.serviceasaservice.server;

import com.cebedo.serviceasaservice.handler.OldPluginHandler;
import com.cebedo.serviceasaservice.handler.OldRunHandler;
import com.cebedo.serviceasaservice.manager.JarManager;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 *
 * @author Vic
 */
public class J2SEServer {

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
        server.createContext("/plugin", new OldPluginHandler());
        server.createContext("/run", new OldRunHandler());
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
