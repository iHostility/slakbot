package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsText {
    private final String type;
    private final String text;
    private final Boolean emoji;

    @JsonCreator
    public ActionsText(@JsonProperty("type") String type,
                       @JsonProperty("text") String text,
                       @JsonProperty("emoji") Boolean emoji) {
        this.type = type;
        this.text = text;
        this.emoji = emoji;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public Boolean getEmoji() {
        return emoji;
    }
}
