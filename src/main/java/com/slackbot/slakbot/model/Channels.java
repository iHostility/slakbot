package com.slackbot.slakbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class Channels {
    @NotBlank
    private final List<Channel> channels;

    @JsonCreator
    public Channels(@JsonProperty("channels") List<Channel> channels) {
        this.channels = channels;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
