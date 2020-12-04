package com.slackbot.slakbot.model.responses.hello;

public class ResponseHelloFinal {
    public static final String messageOK = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"hellook\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"OK! Хорошенько поработай сегодня!\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return messageOK;
    }
}
