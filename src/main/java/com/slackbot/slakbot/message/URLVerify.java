package com.slackbot.slakbot.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class URLVerify {
    @JsonProperty("token")
    private final String token; //: "Jhj5dZrVaK7ZwHHjRyZWjbDl",
    @JsonProperty("challenge")
    private final String challenge; //: "3eZbrw1aBm2rZgRNFdxV2595E9CY3gmdALWMmHkvFXO7tYXAYM8P",
    @JsonProperty("type")
    private final String type; //: "url_verification"

    @JsonCreator
    public URLVerify(@JsonProperty("token") String token, @JsonProperty("challenge") String challenge, @JsonProperty("type") String type) {
        this.token = token;
        this.challenge = challenge;
        this.type = type;
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

}
