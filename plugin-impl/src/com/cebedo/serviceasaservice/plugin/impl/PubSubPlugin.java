package com.cebedo.serviceasaservice.plugin.impl;

import com.cebedo.serviceasaservice.plugin.Plugin;

public class PubSubPlugin implements Plugin {

    private static final String KEY = "pubsub";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String run(String args) {
        String html = "";
        html += "<html>";

        html += "<head>";
        html += "<meta charset='utf-8'>";
        html += "<title>PubSub Plugin</title>";
        html += "</head>";

        html += "<body>";

        html += "<script src='https://cdn.jsdelivr.net/pubsubjs/1.4.2/pubsub.min.js'></script>";

        html += "<script type='text/javascript'>";
        html += "var mySubscriber = function( msg, data ){\n"
                + "console.log( msg, data );\n"
                + "};";
        html += "var token = PubSub.subscribe( 'MY TOPIC', mySubscriber );";
        html += "PubSub.publish( 'MY TOPIC', 'hello world!' );";
        html += "</script>";

        html += "</body>";

        html += "</html>";
        return html;
    }

}
