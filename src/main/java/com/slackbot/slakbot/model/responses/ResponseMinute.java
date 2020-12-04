package com.slackbot.slakbot.model.responses;

public class ResponseMinute {
    private static final String message = "[\n" +
            "    {\n" +
            "      \"type\": \"section\",\n" +
            "      \"block_id\": \"pickaminute\",\n" +
            "      \"text\": {\n" +
            "        \"type\": \"mrkdwn\",\n" +
            "        \"text\": \"Укажи минуту\"\n" +
            "      },\n" +
            "      \"accessory\": {\n" +
            "        \"action_id\": \"pickaminute\",\n" +
            "        \"type\": \"static_select\",\n" +
            "        \"placeholder\": {\n" +
            "          \"type\": \"plain_text\",\n" +
            "          \"text\": \"Select an item\",\n" +
            "          \"emoji\": true\n" +
            "        },\n" +
            "        \"options\": [\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"00\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"00\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"01\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"01\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"02\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"02\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"03\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"03\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"04\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"04\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"05\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"05\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"06\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"06\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"07\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"07\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"08\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"08\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"09\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"09\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"10\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"10\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"11\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"11\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"12\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"12\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"13\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"13\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"14\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"15\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"16\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"16\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"17\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"17\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"18\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"18\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"19\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"19\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"20\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"20\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"21\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"22\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"23\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"23\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"24\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"24\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"25\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"25\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"26\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"26\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"27\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"27\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"28\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"28\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"29\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"29\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"30\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"30\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"31\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"31\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"32\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"32\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"33\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"33\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"34\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"34\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"35\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"35\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"36\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"36\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"37\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"37\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"38\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"38\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"39\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"39\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"40\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"40\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"41\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"41\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"42\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"42\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"43\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"43\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"44\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"44\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"45\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"45\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"46\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"46\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"47\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"47\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"48\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"48\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"49\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"49\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"50\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"50\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"51\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"51\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"52\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"52\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"53\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"53\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"54\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"54\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"55\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"55\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"56\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"56\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"57\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"57\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"58\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"58\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": {\n" +
            "              \"type\": \"plain_text\",\n" +
            "              \"text\": \"59\",\n" +
            "              \"emoji\": true\n" +
            "            },\n" +
            "            \"value\": \"59\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]";

    public static String getMessage() {
        return message;
    }
}
