package com.slackbot.slakbot.model.responses;

public class ResponseHour {
    private static final String message = "[\n" +
            "  {\n" +
            "    \"type\": \"section\",\n" +
            "    \"text\": {\n" +
            "      \"type\": \"mrkdwn\",\n" +
            "      \"text\": \"Укажи час\"\n" +
            "    },\n" +
            "    \"accessory\": {\n" +
            "      \"type\": \"static_select\",\n" +
            "      \"action_id\": \"pickahour\",\n" +
            "      \"placeholder\": {\n" +
            "        \"type\": \"plain_text\",\n" +
            "        \"text\": \"Select an item\",\n" +
            "        \"emoji\": true\n" +
            "      },\n" +
            "      \"options\": [\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"00\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"00\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"01\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"01\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"02\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"02\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"03\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"03\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"04\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"04\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"05\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"05\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"06\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"06\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"07\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"07\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"08\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"08\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"09\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"09\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"10\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"10\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"11\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"11\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"12\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"12\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"13\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"13\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"14\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"15\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"16\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"16\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"17\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"17\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"18\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"18\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"19\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"19\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"20\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"20\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"21\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"22\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"text\": {\n" +
            "            \"type\": \"plain_text\",\n" +
            "            \"text\": \"23\",\n" +
            "            \"emoji\": true\n" +
            "          },\n" +
            "          \"value\": \"23\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "]";

    public static String getMessage() {
        return message;
    }
}
