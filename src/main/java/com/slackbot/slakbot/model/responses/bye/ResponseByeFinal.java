package com.slackbot.slakbot.model.responses.bye;

public class ResponseByeFinal {
    public static final String messageOK = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"byeok\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"OK! Отличная работа!\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return messageOK;
    }
}
