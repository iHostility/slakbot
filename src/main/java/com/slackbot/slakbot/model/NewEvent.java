package com.slackbot.slakbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slackbot.slakbot.message.Event;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public class NewEvent {
    @NotBlank
    private final String token;
    private final String teamID;
    private final String apiAppID;
    private final Event event;
    @NotBlank
    private final String type;
    private final List<String> authedTeams;
    //    private final String channel;
//    private final String user;
//    private final String text;
//    private final String ts;
//    private final String event_ts;
//    private final String channel_type;
    private final String eventId;
    private final LocalDate eventTime;
    private final String challenge;

    public NewEvent(@JsonProperty("token") String token,
                    @JsonProperty("team_id") String teamID,
                    @JsonProperty("api_app_id") String apiAppID,
                    @JsonProperty("event") Event event,
                    @JsonProperty("type") String type,
                    @JsonProperty("authed_teams") List<String> authedTeams,
//                    @JsonProperty("channel") String channel,
//                    @JsonProperty("user") String user,
//                    @JsonProperty("text") String text,
//                    @JsonProperty("ts") String ts,
//                    @JsonProperty("event_ts") String event_ts,
//                    @JsonProperty("channel_type") String channel_type,
                    @JsonProperty("event_id") String eventId,
                    @JsonProperty("event_time") LocalDate eventTime,
                    @JsonProperty("challenge") String challenge
    ) {
        this.token = token;
        this.teamID = teamID;
        this.apiAppID = apiAppID;
        this.event = event;
        this.type = type;
        this.authedTeams = authedTeams;
//        this.channel = channel;
//        this.user = user;
//        this.text = text;
//        this.ts = ts;
//        this.event_ts = event_ts;
//        this.channel_type = channel_type;
        this.eventId = eventId;
        this.eventTime = eventTime;
        this.challenge = challenge;
    }

    public String getApiAppID() {
        return apiAppID;
    }

    public Event getEvent() {
        return event;
    }

    public List<String> getAuthedTeams() {
        return authedTeams;
    }

    public String getToken() {
        return token;
    }

    public String getChallenge() {
        return challenge;
    }

    public String getType() {
        return type;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getEventId() {
        return eventId;
    }

    public LocalDate getEventTime() {
        return eventTime;
    }
    //    public String getChannel() {
//        return channel;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public String getTs() {
//        return ts;
//    }
//
//    public String getEvent_ts() {
//        return event_ts;
//    }
//
//    public String getChannel_type() {
//        return channel_type;
//    }
}
