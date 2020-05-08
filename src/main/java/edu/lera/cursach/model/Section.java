package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Section {
    private String id;
    private String sectionName;
    private String description;
    private Captain captain;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Section() {
    }

    public Section(String id, String sectionName, String description, Captain captain, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.sectionName = sectionName;
        this.description = description;
        this.captain = captain;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection_name() {
        return sectionName;
    }

    public void setSection_name(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
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
}
