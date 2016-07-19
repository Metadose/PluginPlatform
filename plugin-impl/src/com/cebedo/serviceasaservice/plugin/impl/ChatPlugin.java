package com.cebedo.serviceasaservice.plugin.impl;

import com.cebedo.serviceasaservice.plugin.Plugin;
import java.util.ArrayList;
import java.util.List;

public class ChatPlugin implements Plugin {

    private static final String KEY = "chat";
    private static List<String> chatLog = new ArrayList<>();

    private static final String PLUGIN_COMMAND = "get-all";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String run(String args) {
        String[] pluginArgs = args.split(":::");
        String sender = pluginArgs[0];
        if (!sender.equals(PLUGIN_COMMAND)) {
            String message = pluginArgs[1];
            chatLog.add(String.format("%s: %s", sender, message));
        }
        String html = "";
        html += String.format("<form action='/run?'>", PLUGIN_COMMAND);
        html += String.format("<input type='hidden' name='key' value='%s'/>", KEY);
        html += String.format("<input type='hidden' name='args' value='%s'/>", PLUGIN_COMMAND);
        html += "<input type='submit' value='Get All'/>";
        html += "</form>";
        html += String.join("<br/>", chatLog);
        return html;
    }

}
