package com.cebedo.serviceasaservice;

import com.cebedo.serviceasaservice.handler.RequestHandler;
import com.cebedo.serviceasaservice.manager.JarManager;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 *
 * @author Vic
 */
public class Server {

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

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        loadTestJars();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RequestHandler());
        server.setExecutor(null);
        server.start();
    }
}
