package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Sportsman {
    private String id;
    private String sport_kinds;
    private Tourist tourist;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Sportsman() {
    }

    public Sportsman(String id, String sport_kinds, Tourist tourist, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.sport_kinds = sport_kinds;
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

    public String getSport_kinds() {
        return sport_kinds;
    }

    public void setSport_kinds(String sport_kinds) {
        this.sport_kinds = sport_kinds;
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

    public String getName() {
        return this.getTourist().getName();
    }
}
