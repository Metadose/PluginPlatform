package com.cebedo.serviceasaservice.manager;

import com.cebedo.serviceasaservice.plugin.Plugin;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class JarManager {

    private static JarManager instance = null;
    private HashMap<String, Plugin> pluginMap = new HashMap<>();

    private JarManager() {
        ;
    }

    /**
     * Singleton implementation.
     *
     * @return
     */
    public static JarManager getInstance() {
        if (instance == null) {
            instance = new JarManager();
        }
        return instance;
    }

    /**
     *
     * @param key
     * @param args
     * @return
     */
    public String runJar(String key, String[] args) {
        Plugin plugin = pluginMap.get(key);
        return plugin.run(args);
    }

    /**
     * TODO Can be multi-threaded, optimize later.
     *
     * @param jarURL
     * @param className
     * @throws Exception
     */
    public void loadJar(String jarURL, String className) throws Exception {

        // Create a connection to the JAR.
        // Create a class loader.
        URL[] url = new URL[]{new URL(jarURL)};
        URLClassLoader child = new URLClassLoader(url, this.getClass().getClassLoader());

        // Load the class.
        // Create new instance of this class.
        Class classToLoad = Class.forName(className, true, child);
        Object objInstance = classToLoad.newInstance();
        Plugin plugin = (Plugin) objInstance;

        // Map this plugin.
        pluginMap.put(plugin.getKey(), plugin);
    }
}
