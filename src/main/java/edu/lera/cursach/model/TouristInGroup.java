package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class TouristInGroup {
    private String id;
    private Group group;
    private Tourist tourist;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public TouristInGroup() {
    }

    public TouristInGroup(String id, Group group, Tourist tourist, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.group = group;
        this.tourist = tourist;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getModified_date() {
        return modified_date;
    }

    public void setModified_date(LocalDateTime modified_date) {
        this.modified_date = modified_date;
    }
    public String getTouristName() {
        return this.getTourist().getName();
    }
    public String getGroupName() {
        return this.getGroup().getGroup_name();
    }
}
