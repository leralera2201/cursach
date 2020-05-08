package edu.lera.cursach.form;



public class CompetitionForm {
    private String id;
    private String competition_name;
    private String description;
    private String section;
    private String competition_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCompetition_date() {
        return competition_date;
    }

    public void setCompetition_date(String competition_date) {
        this.competition_date = competition_date;
    }

    public CompetitionForm(String id, String competition_name, String description, String section, String competition_date) {
        this.id = id;
        this.competition_name = competition_name;
        this.description = description;
        this.section = section;
        this.competition_date = competition_date;
    }

    public CompetitionForm() {
    }
}
