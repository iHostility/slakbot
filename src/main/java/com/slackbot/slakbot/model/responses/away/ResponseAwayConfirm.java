package com.slackbot.slakbot.model.responses.away;

import java.time.LocalDate;

public class ResponseAwayConfirm {
    private final String hour;
    private final String minute;
    private final LocalDate date;
    private static String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"pickconfirmaway\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Тебя нет с %1$s:%2$s %3$s ?\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"actions\",\n" +
            "      \"elements\": [\n" +
            "        {\n" +
            "          \"type\": \"button\",\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"Подтверждаю!\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"style\": \"primary\",\n" +
            "          \"value\": \"thenaway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";

    public ResponseAwayConfirm(String hour, String minute, LocalDate date) {
        this.hour = hour;
        this.minute = minute;
        this.date = date;
    }

    public static String getMessage() {
        return message;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public LocalDate getDate() {
        return date;
    }

}
