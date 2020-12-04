package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsTeam {
    private final String id;
    private final String domain;

    @JsonCreator
    public ActionsTeam(@JsonProperty("id") String id,
                       @JsonProperty("domain") String domain) {
        this.id = id;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }
}
