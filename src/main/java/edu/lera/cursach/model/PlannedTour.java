package edu.lera.cursach.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PlannedTour {
    private String id;
    private Tour tour;
    private String halt_schedule;
    private String break_schedule;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public PlannedTour() {
    }

    public PlannedTour(String id, Tour tour, String halt_schedule, String break_schedule, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.tour = tour;
        this.halt_schedule = halt_schedule;
        this.break_schedule = break_schedule;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
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
        return this.getTour().getTour_name();
    }
    public LocalDateTime getDate() {
        return this.tour.getTour_date();
    }
}
