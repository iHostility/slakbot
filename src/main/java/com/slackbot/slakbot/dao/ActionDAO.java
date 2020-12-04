package com.slackbot.slakbot.dao;

import com.slackbot.slakbot.actions.NewAction;

import java.time.LocalDateTime;

public interface ActionDAO {

    int addSessionNow(NewAction action);
    int addSessionSelect(NewAction action, LocalDateTime time);
    int closeSessionNow(NewAction action);
    int closeSessionSelect(NewAction action, LocalDateTime time);
    int addLunchNow(NewAction action);
    int addLunchSelect(NewAction action, LocalDateTime time);
    int endLunchNow(NewAction action);
    int endLunchSelect(NewAction action, LocalDateTime time);
    int addAwayNow(NewAction action, String reason); //OPTIONAL REASON
    int addAwaySelect(NewAction action, LocalDateTime time, String reason); //OPTIONAL REASON
    int awayBackNow(NewAction action);
    int awayBackSelect(NewAction action, LocalDateTime time);


//    int insertEvent(UUID id, Event event);
//
//    default int insertEvent (Event event) {
//        UUID id = UUID.randomUUID();
//        return insertEvent(id, event);
//    }
//    List<Event> selectAllEvent();
//    Optional<Event> selectEventByID(UUID id);
//    int deleteEventByID(UUID id);
//    int updateEventByID(UUID id, Event event);
//    String urlVerify (Event event);
//    JsonProcessing sendPayload();
}
