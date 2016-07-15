package com.cebedo.serviceasaservice;

import com.cebedo.serviceasaservice.plugin.Plugin;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class App {

    public void test() throws Exception {
        URL[] classLoaderUrls = new URL[]{new URL("file:///C:/Users/Vic/Documents/Vic/git/ServiceAsAService/sample.jar")};
        URLClassLoader child = new URLClassLoader(classLoaderUrls, this.getClass().getClassLoader());
        Class classToLoad = Class.forName("sample.TestPlugin", true, child);
        Object instance = classToLoad.newInstance();
        Plugin plugin = (Plugin) instance;
        plugin.run();
    }

    public static void main(String[] args) throws Exception {
        // Gather all plugins.
        // Each plugin must have a URL so that it can be called remotely.
        // If a plugin's URL is called, the plugin must run().
        App app = new App();
        app.test();
    }
}
