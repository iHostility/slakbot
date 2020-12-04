package com.slackbot.slakbot.model.responses;

public class ResponseDate {
    private static final String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"pickadate\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Уточни время\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"mrkdwn\",\n" +
            "        \"text\": \"Укажи дату\"\n" +
            "      },\n" +
            "      \"accessory\": {\n" +
            "        \"type\": \"datepicker\",\n" +
            "        \"action_id\": \"datepicker\",\n" +
            "        \"initial_date\": \"2020-09-14\",\n" +
            "        \"placeholder\": {\n" +
            "          \"type\": \"plain_text\",\n" +
            "          \"text\": \"Select a date\",\n" +
            "          \"emoji\": true\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return message;
    }
}
