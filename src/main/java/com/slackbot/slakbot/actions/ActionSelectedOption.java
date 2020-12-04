package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionSelectedOption {
    private final ActionsText text;
    private final String value;

    @JsonCreator
    public ActionSelectedOption(@JsonProperty("text") ActionsText text,
                                @JsonProperty("value") String value) {
        this.text = text;
        this.value = value;
    }

    public ActionsText getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
