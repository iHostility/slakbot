package com.slackbot.slakbot.model.responses.lunchback;

public class ResponseLunchbackFinal {
    public static final String messageOK = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"lunchbackok\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"OK! Ну, с новыми силами!\",\n" +
            "        \"emoji\": true\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return messageOK;
    }
}
