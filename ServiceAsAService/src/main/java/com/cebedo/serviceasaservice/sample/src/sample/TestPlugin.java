package sample;

import com.cebedo.serviceasaservice.plugin.Plugin;

public class TestPlugin implements Plugin {

    private static final String URL_MAPPING = "/hello/world";

    @Override
    public String getURLMapping() {
        return URL_MAPPING;
    }

    @Override
    public String run() {
        System.out.println("Hello Worldddd!");
        return "Hehe!";
    }

}
