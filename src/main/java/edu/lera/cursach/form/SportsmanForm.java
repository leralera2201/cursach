package edu.lera.cursach.form;


public class SportsmanForm {
    private String id;
    private String sport_kinds;
    private String tourist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SportsmanForm(String id, String sport_kinds, String tourist) {
        this.id = id;
        this.sport_kinds = sport_kinds;
        this.tourist = tourist;
    }

    public SportsmanForm() {
    }

    public String getSport_kinds() {
        return sport_kinds;
    }

    public void setSport_kinds(String sport_kinds) {
        this.sport_kinds = sport_kinds;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }
}
