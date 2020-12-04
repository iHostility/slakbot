package com.slackbot.slakbot.model.responses.awayback;

public class ResponseAwaybackFinal {
    public static final String messageOK = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"awaybackok\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"OK! Тогда продолжаем!\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return messageOK;
    }
}
