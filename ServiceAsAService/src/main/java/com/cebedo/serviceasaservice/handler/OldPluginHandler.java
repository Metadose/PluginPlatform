/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cebedo.serviceasaservice.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vic
 */
public class OldPluginHandler implements HttpHandler {

    private static final String ATTR_ACTION = "action";
    private static final String ATTR_URL = "url";
    private static final String ATTR_CLASS = "class";

    // TODO Transfer to a UTIL
    public Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }

    @Override
    public void handle(HttpExchange t) {
        try {
            Map<String, String> params = queryToMap(t.getRequestURI().getQuery());
            //http://localhost:8080/plugin?action=222&url=qwe&class=zx
            String action = params.get(ATTR_ACTION).toString();
            String url = params.get(ATTR_URL).toString();
            String clazz = params.get(ATTR_CLASS).toString();

            String response = action + "\n" + url + "\n" + clazz;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            ;
        }
    }
}
