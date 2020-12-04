package com.slackbot.slakbot.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.slackbot.slakbot.actions.NewAction;
import com.slackbot.slakbot.message.BotToSlackMessage;
import com.slackbot.slakbot.model.responses.ResponseDate;
import com.slackbot.slakbot.model.responses.ResponseHour;
import com.slackbot.slakbot.model.responses.ResponseMinute;
import com.slackbot.slakbot.model.responses.away.ResponseAwayConfirm;
import com.slackbot.slakbot.model.responses.away.ResponseAwayFinal;
import com.slackbot.slakbot.model.responses.awayback.ResponseAwaybackConfirm;
import com.slackbot.slakbot.model.responses.awayback.ResponseAwaybackFinal;
import com.slackbot.slakbot.model.responses.bye.ResponseByeConfirm;
import com.slackbot.slakbot.model.responses.bye.ResponseByeFinal;
import com.slackbot.slakbot.model.responses.hello.ResponseHelloConfirm;
import com.slackbot.slakbot.model.responses.hello.ResponseHelloFinal;
import com.slackbot.slakbot.model.responses.lunch.ResponseLunchConfirm;
import com.slackbot.slakbot.model.responses.lunch.ResponseLunchFinal;
import com.slackbot.slakbot.model.responses.lunchback.ResponseLunchbackConfirm;
import com.slackbot.slakbot.model.responses.lunchback.ResponseLunchbackFinal;
import com.slackbot.slakbot.service.ActionService;
import com.slackbot.slakbot.service.JsonProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequestMapping(value = "api/v1/action")
@RestController
public class ActionController {
    private NewAction newAction;
    private final ActionService actionService;
    //FOR FUTURE IMPLEMENTATION
    @Value("${app.slack.url}")
    private String url;
    @Value("${app.slack.bot-token}")
    private String botToken;
    @Value("${app.slack.channel}")
    private String channel;
    @Value("${app.slack.api-app-id}")
    private String apiAppId;

    private LocalDate date;
    private String hour;
    private String minute;
    private LocalDateTime dateStart;
    private String reason = "";
    private Boolean isHello = false;
    private Boolean isBye = false;
    private Boolean isLunch = false;
    private Boolean isLunchback = false;
    private Boolean isAway = false;
    private Boolean isAwayback = false;


    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping
    @ResponseBody
    public void newActionListener(@NonNull @RequestParam("payload") String action) {
        //RECEIVE BUTTON ACTION
        getPayloadToObject(action);
        try {//TESTING PURPOSES
            System.out.println(JsonProcessing.prettyPrint(JsonProcessing.toJson(newAction)));
        } catch (Exception e) {
        }
        //PROCESS ACTION
        try { //AUXILIARY FOR SELECTED DATE
            if (newAction.getActions().get(0).getSelectedDate() != null)
                date = LocalDate.parse(newAction.getActions().get(0).getSelectedDate());
        } catch (Exception e) {
            System.out.println("Action EAT SHIT w/ date field");
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////IMMEDIATE ACTIONS AHEAD/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //SESSION START IF NOW BUTTON ACTION
        //HELLO ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("hellonow")) {
            actionService.sessionStart(newAction);
            try {
                sendHelloBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //SESSION END IF NOW BUTTON ACTION
        //BYE ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("byenow")) {
            actionService.sessionEnd(newAction);
            try {
                sendByeBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //LUNCHSTART COLUMN SET IF NOW BUTTON ACTION
        //LUNCH ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("lunchnow")) {
            actionService.lunchStart(newAction);
            try {
                sendLunchBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //LUNCHBACK COLUMN SET IF NOW BUTTON ACTION
        //LUNCHBACK ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("lunchbacknow")) {
            actionService.lunchEnd(newAction);
            try {
                sendLunchBackBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //AWAY COLUMN SET IF NOW BUTTON ACTION
        //AWAY ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("awaynow")) {
            actionService.awayStart(newAction, reason);
            try {
                sendAwayBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //AWAYBACK COLUMN SET IF NOW BUTTON ACTION
        //AWAYBACK ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("awaybacknow")) {
            actionService.awayEnd(newAction);
            try {
                sendAwayBackBlockFinal();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////DIALOGUE ACTIONS AHEAD//////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION HELLO CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selecthello")) {
            isHello = true;
            try {
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION BYE CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selectbye")) {
            try {
                isBye = true;
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION LUNCH CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selectlunch")) {
            try {
                isLunch = true;
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION LUNCHBACK CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selectlunchback")) {
            try {
                isLunchback = true;
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION AWAY CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selectaway")) {
            try {
                isAway = true;
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE INITIATED IF SPECIFY BUTTON ACTION
        //DATE BLOCK SENDING
        //ACTION AWAYBACK CHAIN
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("selectawayback")) {
            try {
                isAwayback = true;
                sendDateBlock();
            } catch (IOException e) {
                System.out.println("Fucked up DateBlock");
            }
        }
        //DIALOGUE PROCEED IF DATE PICKED
        //HOUR BLOCK SENDING
        if (newAction.getActions().get(0).getActionID().equalsIgnoreCase("datepicker")) {
            try {
                sendHourBlock();
            } catch (JsonProcessingException e) {
                System.out.println("Fucked up HourBlock");
            }
        }
        //DIALOGUE PROCEED IF HOUR PICKED
        //MINUTE BLOCK SENDING
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getActionID().equalsIgnoreCase("pickahour")) {
            try {
                this.hour = newAction.getActions().get(0).getSelectedOption().getValue();
                sendMinuteBlock();
            } catch (JsonProcessingException e) {
                System.out.println("Fucked up MinuteBlock");
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION HELLO
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isHello) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendHelloConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION BYE
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isBye) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendByeConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION LUNCH
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isLunch) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendLunchConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION LUNCHBACK
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isLunchback) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendLunchBackConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION AWAY
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isAway) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendAwayConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE PROCEED IF MINUTE PICKED
        //SELECTED OPTIONS DISPLAYED
        //CONFIRMATION BUTTON BLOCK SENDING
        //ACTION AWAYBACK
        if (newAction.getActions().get(0).getType().equalsIgnoreCase("static_select") &&
                newAction.getActions().get(0).getBlockID().equalsIgnoreCase("pickaminute") && isAwayback) {
            this.minute = newAction.getActions().get(0).getSelectedOption().getValue();
            try {
                sendAwayBackConfirmBlock();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL OK BLOCK SENDING
        //HELLO ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenhello")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //START NEW SESSION /W CUSTOM TIME HERE
                actionService.sessionStartSelect(newAction, dateStart);
                sendHelloBlockFinal();
                isHello = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL BYEOK BLOCK SENDING
        //BYE ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenbye")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //START NEW SESSION /W CUSTOM TIME HERE
                actionService.sessionEndSelect(newAction, dateStart);
                sendByeBlockFinal();
                isBye = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL LUNCHOK BLOCK SENDING
        //LUNCH ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenlunch")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //SET LUNCHSTART COLUMN /W CUSTOM TIME HERE
                actionService.lunchStartSelect(newAction, dateStart);
                sendLunchBlockFinal();
                isLunch = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL LUNCHBACKOK BLOCK SENDING
        //LUNCHBACK ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenlunchback")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //SET LUNCHEND COLUMN /W CUSTOM TIME HERE
                actionService.lunchEndSelect(newAction, dateStart);
                sendLunchBackBlockFinal();
                isLunchback = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL AWAYOK BLOCK SENDING
        //AWAY ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenaway")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //SET AWAYSTART COLUMN /W CUSTOM TIME HERE
                actionService.awayStartSelect(newAction, dateStart, reason);
                sendAwayBlockFinal();
                isAway = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
        //DIALOGUE ENDED IF CONFIRMATION BUTTON ACTION
        //FINAL AWAYBACKOK BLOCK SENDING
        //AWAYBACK ACTION
        if (newAction.getActions().get(0).getValue() != null &&
                newAction.getActions().get(0).getValue().equalsIgnoreCase("thenawayback")) {
            try {
                String s = String.format("%1$sT%2$s:%3$s", date, hour, minute);
                dateStart = LocalDateTime.parse(s);
                //SET AWAYEND COLUMN /W CUSTOM TIME HERE
                actionService.awayEndSelect(newAction, dateStart);
                sendAwayBackBlockFinal();
                isAwayback = false;
            } catch (Exception e) {
                System.out.println("Action EAT SHIT tried start session select");
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////PROCESSING METHODS AHEAD////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ACTION TO OBJECT METHOD
    void getPayloadToObject(String string) {
        try {
            JsonNode node = JsonProcessing.parse(string);
            newAction = JsonProcessing.fromJson(node, NewAction.class);
        } catch (IOException e) {
            System.out.println("FUCKED UP PAYLOAD PROCESSING, SOWWY");
        }
    }


    //DATE PICKER BLOCK
    void sendDateBlock() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                ResponseDate.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //HOUR SELECT BLOCK
    void sendHourBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                ResponseHour.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //MINUTE SELECT BLOCK
    void sendMinuteBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                ResponseMinute.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM HELLO ACTION BLOCK
    void sendHelloConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseHelloConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM BYE ACTION BLOCK
    void sendByeConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseByeConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM LUNCH ACTION BLOCK
    void sendLunchConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseLunchConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM LUNCHBACK ACTION BLOCK
    void sendLunchBackConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseLunchbackConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM AWAY ACTION BLOCK
    void sendAwayConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseAwayConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //CONFIRM AWAYBACK ACTION BLOCK
    void sendAwayBackConfirmBlock() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage message = new BotToSlackMessage(
                botToken,
                channel,
                "TEXT",
                String.format(ResponseAwaybackConfirm.getMessage(), hour, minute, date)
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(message)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //HELLO ACTION FINAL BLOCK
    void sendHelloBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseHelloFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //BYE ACTION FINAL BLOCK
    void sendByeBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseByeFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //LUNCH ACTION FINAL BLOCK
    void sendLunchBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseLunchFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //LUNCHBACK ACTION FINAL BLOCK
    void sendLunchBackBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseLunchbackFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //AWAY ACTION FINAL BLOCK
    void sendAwayBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseAwayFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }

    //AWAYBACK ACTION FINAL BLOCK
    void sendAwayBackBlockFinal() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.setBearerAuth(botToken);
        BotToSlackMessage botToSlackMessage = new BotToSlackMessage(
                botToken,
                channel,
                "ok",
                ResponseAwaybackFinal.getMessage()
        );
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = new HttpEntity<String>(JsonProcessing.stringify(JsonProcessing.toJson(botToSlackMessage)), headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(newAction.getResponseUrl(), response, String.class);
    }
}
