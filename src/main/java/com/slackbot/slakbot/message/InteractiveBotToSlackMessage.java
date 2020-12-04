package com.slackbot.slakbot.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InteractiveBotToSlackMessage {
    private final String text;
//    private final String hour;
//    private final String minute;
//    private final LocalDate date;
//    private final String blocks;

    @JsonCreator
    public InteractiveBotToSlackMessage(@JsonProperty("text") String text)
//                                        @JsonProperty("hour") String hour,
//                                        @JsonProperty("minute") String minute,
//                                        @JsonProperty("date") LocalDate date,
//                                        @JsonProperty("blocks") String blocks)
    {
        this.text = text;
//        this.hour = hour;
//        this.minute = minute;
//        this.date = date;
//        this.blocks = blocks;
    }

//    public String getHour() {
//        return hour;
//    }
//
//    public String getMinute() {
//        return minute;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public String getBlocks() {
//        return blocks;
//    }

    public String getText() {
        return text;
    }
}
