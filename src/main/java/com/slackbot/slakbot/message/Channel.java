package com.slackbot.slakbot.message;

import java.util.List;

public class Channel {

    private String token; // "one-long-verification-token",
    private String team_id; //"T061EG9R6",
    private String api_app_id; //: "A0PNCHHK2",
    private Event event; //see EventPOJO class
    private String type; //:"event_callback",
    private List<String> authed_teams;//
    private String event_id; //:"Ev0PV52K21",
    private String event_time; //:1355517523

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getApi_app_id() {
        return api_app_id;
    }

    public void setApi_app_id(String api_app_id) {
        this.api_app_id = api_app_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAuthed_teams() {
        return authed_teams;
    }

    public void setAuthed_teams(List<String> authed_teams) {
        this.authed_teams = authed_teams;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }
}
