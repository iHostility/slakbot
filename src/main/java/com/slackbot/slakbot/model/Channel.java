package com.slackbot.slakbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Channel {
    private final String id; //:"D0C0F7S8Y",
    private final LocalDate created; //:1498500348,
    private final Boolean isIM; //:true,
    private final Boolean isOrgShared; //:false,
    private final String user; //:"U0BS9U4SV",
    private final Boolean isUserDeleted; //"is_user_deleted":false,
    private final float priority; //"priority":0

    @JsonCreator
    public Channel(@JsonProperty("id") String id,
                   @JsonProperty("created") LocalDate created,
                   @JsonProperty("is_im") Boolean isIM,
                   @JsonProperty("is_org_shared") Boolean isOrgShared,
                   @JsonProperty("user") String user,
                   @JsonProperty("is_user_deleted") Boolean isUserDeleted,
                   @JsonProperty("priority") float priority) {
        this.id = id;
        this.created = created;
        this.isIM = isIM;
        this.isOrgShared = isOrgShared;
        this.user = user;
        this.isUserDeleted = isUserDeleted;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Boolean getIs_im() {
        return isIM;
    }

    public Boolean getIs_org_shared() {
        return isOrgShared;
    }

    public String getUser() {
        return user;
    }

    public Boolean getIs_user_deleted() {
        return isUserDeleted;
    }

    public Boolean getIM() {
        return isIM;
    }

    public Boolean getOrgShared() {
        return isOrgShared;
    }

    public Boolean getUserDeleted() {
        return isUserDeleted;
    }

    public float getPriority() {
        return priority;
    }
}
