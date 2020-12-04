package com.slackbot.slakbot.model.responses.lunch;

public class ResponseLunchFinal {
    public static final String messageOK = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"lunchok\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"OK! Приятного аппетита!\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return messageOK;
    }
}
