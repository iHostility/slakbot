package com.slackbot.slakbot.model.responses.awayback;

public class ResponseAwayback {
    private static final String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Привет. Ты давно на месте?\",\n" +
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
            "            \"emoji\": true,\n" +
            "            \"text\": \"Сейчас\"\n" +
            "          },\n" +
            "          \"style\": \"primary\",\n" +
            "          \"value\": \"awaybacknow\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"button\",\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"emoji\": true,\n" +
            "            \"text\": \"Я укажу время\"\n" +
            "          },\n" +
            "          \"style\": \"danger\",\n" +
            "          \"value\": \"selectawayback\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return message;
    }
}
