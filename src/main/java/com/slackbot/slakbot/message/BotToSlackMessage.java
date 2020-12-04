package com.slackbot.slakbot.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotToSlackMessage {
    private final String token;
    private final String channel;
    private final String text;
    private final String blocks;

    @JsonCreator
    public BotToSlackMessage(@JsonProperty("token") String token,
                             @JsonProperty("channel") String channel,
                             @JsonProperty("text") String text,
                             @JsonProperty("blocks") String blocks) {
        this.token = token;
        this.channel = channel;
        this.text = text;
        this.blocks = blocks;
    }

    public String getToken() {
        return token;
    }

    public String getChannel() {
        return channel;
    }

    public String getText() {
        return text;
    }

    public String getBlocks() {
        return blocks;
    }
}
