package com.slackbot.slakbot.model.responses.lunch;

public class ResponseLunch {
    private static final String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Ты на обед? И давно?\",\n" +
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
            "          \"value\": \"lunchnow\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"button\",\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"emoji\": true,\n" +
            "            \"text\": \"Я укажу время\"\n" +
            "          },\n" +
            "          \"style\": \"danger\",\n" +
            "          \"value\": \"selectlunch\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return message;
    }
}
