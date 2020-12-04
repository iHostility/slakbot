package com.slackbot.slakbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.slackbot.slakbot.service.pojo.AuthorPOJO;
import com.slackbot.slakbot.service.pojo.BookPOJO;
import com.slackbot.slakbot.service.pojo.DayPOJO;
import com.slackbot.slakbot.service.pojo.SimpleTestCaseEventPOJO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonProcessingTest {

    private String simpleTestCaseEventSource = "{\n" +
            "  \"title\": \"title text\",\n" +
            "  \"author\": \"Biggus Diccus\"\n" +
            "}";
    private String dayScenario1 = "{\n" +
            "  \"date\": \"2019-12-25\",\n" +
            "  \"name\": \"Christmas Day\"\n" +
            "}";
    private String authorBookScenario ="{\n" +
            "  \"authorName\": \"Hostile\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inPrint\": true,\n" +
            "      \"publishDate\": \"2019-12-25\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inPrint\": false,\n" +
            "      \"publishDate\": \"2019-01-01\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    void parse() throws IOException {
        JsonNode node = JsonProcessing.parse(simpleTestCaseEventSource);
        assertEquals(node.get("title").asText(), "title text");
    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = JsonProcessing.parse(simpleTestCaseEventSource);
        SimpleTestCaseEventPOJO pojo = JsonProcessing.fromJson(node, SimpleTestCaseEventPOJO.class);

        assertEquals(pojo.getTitle(), "title text");
    }
    @Test
    void toJson(){
        SimpleTestCaseEventPOJO pojo = new SimpleTestCaseEventPOJO();
        pojo.setTitle("Testing 123");

        JsonNode node = JsonProcessing.toJson(pojo);
        assertEquals(node.get("title").asText(), "Testing 123");
    }

    @Test
    void stringify() throws JsonProcessingException {
        SimpleTestCaseEventPOJO pojo = new SimpleTestCaseEventPOJO();
        pojo.setTitle("Testing 123");

        JsonNode node = JsonProcessing.toJson(pojo);

        System.out.println(JsonProcessing.stringify(node));
        System.out.println(JsonProcessing.prettyPrint(node));
    }

    @Test
    void dayTestScenario1() throws IOException {
        JsonNode node = JsonProcessing.parse(dayScenario1);
        DayPOJO pojo = JsonProcessing.fromJson(node, DayPOJO.class);

        assertEquals("2019-12-25", pojo.getDate().toString());
    }

    @Test
    void authorBookScenario() throws IOException {
        JsonNode node = JsonProcessing.parse(authorBookScenario);
        AuthorPOJO pojo = JsonProcessing.fromJson(node, AuthorPOJO.class);

        System.out.println("Author : " + pojo.getAuthorName());
        for (BookPOJO bP : pojo.getBooks())
        {
            System.out.println("Book : " + bP.getTitle());
            System.out.println("Is In Print? " + bP.getInPrint());
            System.out.println("Date : " + bP.getPublishDate());
        }

    }
}