package edu.lera.cursach.form;


public class ParticipationInCompetitionForm {
    private String id;
    private String competition;
    private String tourist;

    public ParticipationInCompetitionForm(String id, String competition, String tourist) {
        this.id = id;
        this.competition = competition;
        this.tourist = tourist;
    }

    public ParticipationInCompetitionForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }
}
