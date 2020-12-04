package com.slackbot.slakbot.service;

import com.slackbot.slakbot.actions.NewAction;
import com.slackbot.slakbot.dao.ActionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActionService {

    private final ActionDAO actionDAO;

    @Autowired
    public ActionService(@Qualifier("postgres") ActionDAO actionDAO) {
        this.actionDAO = actionDAO;
    }

    public int sessionStart(NewAction action) {
        return actionDAO.addSessionNow(action);
    }

    public int sessionStartSelect(NewAction action, LocalDateTime time) {
        return actionDAO.addSessionSelect(action, time);
    }

    public int sessionEnd(NewAction action) {
        return actionDAO.closeSessionNow(action);
    }

    public int sessionEndSelect(NewAction action, LocalDateTime time) {
        return actionDAO.closeSessionSelect(action, time);
    }

    public int lunchStart(NewAction action) {
        return actionDAO.addLunchNow(action);
    }

    public int lunchStartSelect(NewAction action, LocalDateTime time) {
        return actionDAO.addLunchSelect(action, time);
    }

    public int lunchEnd(NewAction action) {
        return actionDAO.endLunchNow(action);
    }

    public int lunchEndSelect(NewAction action, LocalDateTime time) {
        return actionDAO.endLunchSelect(action, time);
    }

    public int awayStart(NewAction action, String reason) {
        return actionDAO.addAwayNow(action, reason);
    }

    public int awayStartSelect(NewAction action, LocalDateTime time, String reason) {
        return actionDAO.addAwaySelect(action, time, reason);
    }

    public int awayEnd(NewAction action) {
        return actionDAO.awayBackNow(action);
    }

    public int awayEndSelect(NewAction action, LocalDateTime time) {
        return actionDAO.awayBackSelect(action, time);
    }
}