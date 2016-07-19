package com.cebedo.serviceasaservice.plugin.impl;

import com.cebedo.serviceasaservice.plugin.Plugin;

public class TestPluginImpl implements Plugin {

    private static final String KEY = "hello-world";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String run() {
        System.out.println("Hello Worldddd!");
        return "Hehe!";
    }

}
