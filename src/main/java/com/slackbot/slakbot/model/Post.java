package com.slackbot.slakbot.model;

import java.io.Serializable;

public class Post implements Serializable {

    private String body;

    public Post(String body) {
        this.body = body;
    }

    // getters and setters

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
