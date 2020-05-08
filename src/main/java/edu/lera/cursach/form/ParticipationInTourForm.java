package edu.lera.cursach.form;


public class ParticipationInTourForm {
    private String id;
    private String tour;
    private String tourist;

    public ParticipationInTourForm(String id, String tour, String tourist) {
        this.id = id;
        this.tour = tour;
        this.tourist = tourist;
    }

    public ParticipationInTourForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }
}
