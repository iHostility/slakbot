package com.slackbot.slakbot.model.responses.lunchback;

import java.time.LocalDate;

public class ResponseLunchbackConfirm {
    private final String hour;
    private final String minute;
    private final LocalDate date;
    private static String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"pickconfirmhello\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Ты на месте с %1$s:%2$s %3$s ?\",\n" +
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
            "          \"value\": \"thenlunchback\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";

    public ResponseLunchbackConfirm(String hour, String minute, LocalDate date) {
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
