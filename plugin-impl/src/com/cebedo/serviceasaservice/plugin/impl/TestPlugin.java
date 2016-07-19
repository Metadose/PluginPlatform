package com.cebedo.serviceasaservice.plugin.impl;

import com.cebedo.serviceasaservice.plugin.Plugin;

public class TestPlugin implements Plugin {

    private static final String KEY = "hello-world";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String run(String[] args) {
        return String.join(" ", args);
    }

}
