package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class UnplannedTour {
    private String id;
    private Tour tour;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public UnplannedTour() {
    }

    public UnplannedTour(String id, Tour tour, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.tour = tour;
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

    public LocalDateTime getDate() {
        return this.getTour().getTour_date();
    }
}
