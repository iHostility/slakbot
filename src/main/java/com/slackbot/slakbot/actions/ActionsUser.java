package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsUser {
        private final String id;
        private final String username;
        private final String name;
        private final String teamID;

    public ActionsUser(@JsonProperty("id") String id,
                       @JsonProperty("username") String username,
                       @JsonProperty("name") String name,
                       @JsonProperty("team_id") String teamID) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.teamID = teamID;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getTeam_id() {
        return teamID;
    }
}
