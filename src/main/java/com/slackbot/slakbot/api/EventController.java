package com.slackbot.slakbot.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.slackbot.slakbot.message.BotToSlackMessage;
import com.slackbot.slakbot.model.Channels;
import com.slackbot.slakbot.model.NewEvent;
import com.slackbot.slakbot.model.responses.away.ResponseAway;
import com.slackbot.slakbot.model.responses.awayback.ResponseAwayback;
import com.slackbot.slakbot.model.responses.bye.ResponseBye;
import com.slackbot.slakbot.model.responses.hello.ResponseHello;
import com.slackbot.slakbot.model.responses.lunch.ResponseLunch;
import com.slackbot.slakbot.model.responses.lunchback.ResponseLunchback;
import com.slackbot.slakbot.service.JsonProcessing;
import com.slackbot.slakbot.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;


@RequestMapping(value = "api/v1/event")
@RestController
public class EventController {
    @Value("${app.slack.url}")
    private String url;
    @Value("${app.slack.url-im-list}")
    private String imUrl;

    @Value("${app.slack.bot-token}")
    private String botToken;

    @Value("${app.slack.channel}")
    private String channel;
    private String channelIM;

    @Value("${app.slack.api-app-id}")
    private String apiAppId;

    private NewEvent newEvent;

    private final RestService restService;

    @Autowired
    public EventController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping
    @ResponseBody
    public String newEventListener(@NonNull @Valid @RequestBody NewEvent newEvent) {
        this.newEvent = newEvent;

        if (newEvent.getType().equalsIgnoreCase("url_verification")) {
            return newEvent.getChallenge();
        }

        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().equalsIgnoreCase("привет")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmHello();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }

        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().equalsIgnoreCase("пока")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmBye();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().equalsIgnoreCase("обед")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmLunch();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().contains("вернул")
                && newEvent.getEvent().getText().contains("обеда")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmLunchback();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().contains("отош")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmAway();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        if (newEvent.getEvent().getText() != null
                && newEvent.getEvent().getText().contains("вернул")
                && !newEvent.getEvent().getText().contains("обеда")
                && newEvent.getType().equalsIgnoreCase("event_callback")) {
            try {
                sendDmAwayback();
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        return "ok";
    }

    //POST METHOD FOR HELLO EVENT
    public void sendHelloBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "I SEE YOU",
                ResponseHello.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM HELLO SEND
    public void sendDmHello() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendHelloBlock(channelIM);
        channelIM = null;
    }

    //POST METHOD FOR BYE EVENT
    public void sendByeBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "I DON'T SEE YOU",
                ResponseBye.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM BYE SEND
    public void sendDmBye() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendByeBlock(channelIM);
        channelIM = null;
    }

    //POST METHOD FOR LUNCH EVENT
    public void sendLunchBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "TIME TO FEED",
                ResponseLunch.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM LUNCH SEND
    public void sendDmLunch() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendLunchBlock(channelIM);
        channelIM = null;
    }

    //POST METHOD FOR LUNCHBACK EVENT
    public void sendLunchbackBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "NOT HUNGRY ANYMORE",
                ResponseLunchback.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM LUNCHBACK SEND
    public void sendDmLunchback() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendLunchbackBlock(channelIM);
        channelIM = null;
    }

    //POST METHOD FOR AWAY EVENT
    public void sendAwayBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "FALLING BACK?",
                ResponseAway.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM AWAY SEND
    public void sendDmAway() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendAwayBlock(channelIM);
        channelIM = null;
    }

    //POST METHOD FOR AWAYBACK EVENT
    public void sendAwaybackBlock(String channel) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(botToken,
                channel,
                "WELCOME BACK!",
                ResponseAwayback.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, response, String.class);
    }

    //DM AWAY SEND
    public void sendDmAwayback() throws IOException {
        String s = getDMList();
        Channels channels = JsonProcessing.fromJson(JsonProcessing.parse(s), Channels.class);
        String user = newEvent.getEvent().getUser(); //EVENT INITIATOR
        String usertoReply;
        String channelToReply;
        for (int i = 0; i < channels.getChannels().size(); i++) {
            usertoReply = channels.getChannels().get(i).getUser();
            channelToReply = channels.getChannels().get(i).getId();
            if (usertoReply.equalsIgnoreCase(user)) channelIM = channelToReply;
        }
        sendAwaybackBlock(channelIM);
        channelIM = null;
    }


    //GET LIST OF DM CHANNELS OF ALL USERS
    public String getDMList() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(botToken);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                imUrl,
                HttpMethod.GET,
                request,
                String.class
        );
        return response.getBody();
    }

}
