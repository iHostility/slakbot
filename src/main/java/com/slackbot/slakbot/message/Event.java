package com.slackbot.slakbot.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

public class Event {
    @NotBlank
    private String type; //:"message",
    @NotBlank
    private String channel; //:"D024BE91L",
    @NotBlank
    private String user; //:"U2147483697",
    @NotBlank
    private String text; //:"Hello hello can you hear me?",
    @NotBlank
    private String ts; //:"1355517523.000005",
    private String event_ts; //:"1355517523.000005",
    @NotBlank
    private String channel_type; //:"im"
//    private String challenge; //:"3eZbrw1aBm2rZgRNFdxV2595E9CY3gmdALWMmHkvFXO7tYXAYM8P"
//    private String token; //:"3eZbrw1aBm2rZgRNFdxV2595E9CY3gmdALWMmHkvFXO7tYXAYM8P"

    public Event (@JsonProperty("type") String type,
                          @JsonProperty("channel") String channel,
                          @JsonProperty("user") String user,
                          @JsonProperty("text") String text,
                          @JsonProperty("ts") String ts,
                          @JsonProperty("event_ts") String event_ts
//                          @JsonProperty("channel_type") String channel_type,
//                          @JsonProperty("token") String token
    ) {
        this.type = type;
        this.channel = channel;
        this.user = user;
        this.text = text;
        this.ts = ts;
        this.event_ts = event_ts;
//        this.channel_type = channel_type;
//        this.token = token;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public String getChallenge() {
//        return challenge;
//    }
//
//    public void setChallenge(String challenge) {
//        this.challenge = challenge;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getEvent_ts() {
        return event_ts;
    }

    public void setEvent_ts(String event_ts) {
        this.event_ts = event_ts;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }
}
