package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewAction {
    private final String type;
    private final ActionsUser user;
    private final String api_app_id;
    private final String token;
    private final ActionsContainer container;
    private final String triggerID;
    private final ActionsTeam team;
    private final String responseUrl;
    private final List<ActionsActions> actions;

    @JsonCreator
    public NewAction(@JsonProperty("type") String type,
                     @JsonProperty("user") ActionsUser user,
                     @JsonProperty("api_app_id") String api_app_id,
                     @JsonProperty("token") String token,
                     @JsonProperty("container") ActionsContainer container,
                     @JsonProperty("trigger_id") String triggerID,
                     @JsonProperty("team") ActionsTeam team,
                     @JsonProperty("response_url") String responseUrl,
                     @JsonProperty("actions") List<ActionsActions> actions) {
        this.type = type;
        this.user = user;
        this.api_app_id = api_app_id;
        this.token = token;
        this.container = container;
        this.triggerID = triggerID;
        this.team = team;
        this.responseUrl = responseUrl;
        this.actions = actions;
    }

    public String getType() {
        return type;
    }

    public ActionsUser getUser() {
        return user;
    }

    public String getApi_app_id() {
        return api_app_id;
    }

    public String getToken() {
        return token;
    }

    public ActionsContainer getContainer() {
        return container;
    }

    public String getTrigger_id() {
        return triggerID;
    }

    public ActionsTeam getTeam() {
        return team;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public List<ActionsActions> getActions() {
        return actions;
    }
}
