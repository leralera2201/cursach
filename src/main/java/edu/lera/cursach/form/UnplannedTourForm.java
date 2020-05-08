package edu.lera.cursach.form;


public class UnplannedTourForm {
    private String id;
    private String tour;

    public UnplannedTourForm() {
    }

    public UnplannedTourForm(String id, String tour) {
        this.id = id;
        this.tour = tour;
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
}
