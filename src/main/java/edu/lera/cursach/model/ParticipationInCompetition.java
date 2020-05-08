package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class ParticipationInCompetition {
    private String id;
    private Competition competition;
    private Tourist tourist;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public ParticipationInCompetition() {
    }

    public ParticipationInCompetition(String id, Competition competition, Tourist tourist, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.competition = competition;
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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
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
    public String getCompetitionName() {
        return this.getCompetition().getCompetition_name();
    }
}
