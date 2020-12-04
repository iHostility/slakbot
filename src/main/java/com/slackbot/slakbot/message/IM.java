package com.slackbot.slakbot.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public class IM {
    @NotBlank
    private String token; // "one-long-verification-token",
    private String team_id; //"T061EG9R6",
    private String api_app_id; //: "A0PNCHHK2",
    @NotBlank
    private Event event; //see Event class
    private String type; //:"event_callback",
    private List<String> authedTeams;//
    private String eventId; //:"Ev0PV52K21",
    private LocalDate eventTime; //:1355517523
    private String channelType;

    @JsonCreator
    public IM(@JsonProperty("token") String token,
              @JsonProperty("team_id") String team_id,
              @JsonProperty("api_app_id") String api_app_id,
              @JsonProperty("event") Event event,
              @JsonProperty("type") String type,
              @JsonProperty("authed_teams") List<String> authedTeams,
              @JsonProperty("event_id") String eventId,
              @JsonProperty("event_time") LocalDate eventTime,
              @JsonProperty("channel_type") String channelType) {
        this.token = token;
        this.team_id = team_id;
        this.api_app_id = api_app_id;
        this.event = event;
        this.type = type;
        this.authedTeams = authedTeams;
        this.eventId = eventId;
        this.eventTime = eventTime;
        this.channelType = channelType;

    }

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

    public List<String> getAuthedTeams() {
        return authedTeams;
    }

    public void setAuthedTeams(List<String> authedTeams) {
        this.authedTeams = authedTeams;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDate getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDate eventTime) {
        this.eventTime = eventTime;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
