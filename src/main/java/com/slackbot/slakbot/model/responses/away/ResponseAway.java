package com.slackbot.slakbot.model.responses.away;

public class ResponseAway {
    private static final String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Ты не на месте? И давно?\",\n" +
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
            "          \"value\": \"awaynow\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"button\",\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"emoji\": true,\n" +
            "            \"text\": \"Я укажу время\"\n" +
            "          },\n" +
            "          \"style\": \"danger\",\n" +
            "          \"value\": \"selectaway\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return message;
    }
}
