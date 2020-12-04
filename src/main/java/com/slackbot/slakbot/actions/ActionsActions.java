package com.slackbot.slakbot.actions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsActions {
    private final String type;
    private final String blockID;
    private final String actionID;
    private final ActionsText text;
    private final String value;
    private final String style;
    private final String actionTS;
    private final String selectedDate;
    private final ActionSelectedOption selectedOption;

    @JsonCreator
    public ActionsActions(@JsonProperty("type") String type,
                          @JsonProperty("block_id") String blockID,
                          @JsonProperty("action_id") String actionID,
                          @JsonProperty("text") ActionsText text,
                          @JsonProperty("value") String value,
                          @JsonProperty("style") String style,
                          @JsonProperty("action_ts") String actionTS,
                          @JsonProperty("selected_date") String selectedDate,
                          @JsonProperty("selected_option") ActionSelectedOption selectedOption) {
        this.type = type;
        this.blockID = blockID;
        this.actionID = actionID;
        this.text = text;
        this.value = value;
        this.style = style;
        this.actionTS = actionTS;
        this.selectedDate = selectedDate;
        this.selectedOption = selectedOption;
    }

    public String getType() {
        return type;
    }

    public String getBlockID() {
        return blockID;
    }

    public String getActionID() {
        return actionID;
    }

    public ActionsText getText() {
        return text;
    }

    public String getValue() {
        return value;
    }

    public String getStyle() {
        return style;
    }

    public String getActionTS() {
        return actionTS;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public ActionSelectedOption getSelectedOption() {
        return selectedOption;
    }
}
