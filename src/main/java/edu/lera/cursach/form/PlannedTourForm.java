package edu.lera.cursach.form;


public class PlannedTourForm {
    private String id;
    private String tour;
    private String halt_schedule;
    private String break_schedule;

    public PlannedTourForm() {
    }

    public PlannedTourForm(String id, String tour, String halt_schedule, String break_schedule) {
        this.id = id;
        this.tour = tour;
        this.halt_schedule = halt_schedule;
        this.break_schedule = break_schedule;
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

    public String getHalt_schedule() {
        return halt_schedule;
    }

    public void setHalt_schedule(String halt_schedule) {
        this.halt_schedule = halt_schedule;
    }

    public String getBreak_schedule() {
        return break_schedule;
    }

    public void setBreak_schedule(String break_schedule) {
        this.break_schedule = break_schedule;
    }
}
