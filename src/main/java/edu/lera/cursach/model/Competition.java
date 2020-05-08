package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Competition {
    private String id;
    private String competitionName;
    private String description;
    private Section section;
    private LocalDateTime competition_date;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Competition() {
    }

    public Competition(String id, String competitionName, String description, Section section, LocalDateTime competition_date, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.competitionName = competitionName;
        this.description = description;
        this.section = section;
        this.competition_date = competition_date;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetition_name() {
        return competitionName;
    }

    public void setCompetition_name(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public LocalDateTime getCompetition_date() {
        return competition_date;
    }

    public void setCompetition_date(LocalDateTime competition_date) {
        this.competition_date = competition_date;
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
