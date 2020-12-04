package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsContainer {
    private final String type;
    private final String text;

    @JsonCreator
    public ActionsContainer(@JsonProperty("type") String type,
                            @JsonProperty("text") String text) {
        this.type = type;
        this.text = text;

    }


    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
