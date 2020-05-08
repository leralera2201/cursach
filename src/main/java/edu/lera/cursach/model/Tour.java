package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Tour {
    private String id;
    private String tourName;
    private String tour_description;
    private Tourist instructor;
    private Group group;
    private Double tour_full_time;
    private Double payment;
    private String route;
    private String route_length;
    private LocalDateTime tour_date;
    private TourType tour_type;
    private Category category;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Tour() {
    }

    public Tour(String id, String tourName, String tour_description, Tourist instructor, Group group, Double tour_full_time, Double payment, String route, String route_length, LocalDateTime tour_date, TourType tour_type, Category category, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.tourName = tourName;
        this.tour_description = tour_description;
        this.instructor = instructor;
        this.group = group;
        this.tour_full_time = tour_full_time;
        this.payment = payment;
        this.route = route;
        this.route_length = route_length;
        this.tour_date = tour_date;
        this.tour_type = tour_type;
        this.category = category;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTour_name() {
        return tourName;
    }

    public void setTour_name(String tourName) {
        this.tourName = tourName;
    }

    public String getTour_description() {
        return tour_description;
    }

    public void setTour_description(String tour_description) {
        this.tour_description = tour_description;
    }

    public Tourist getInstructor() {
        return instructor;
    }

    public void setInstructor(Tourist instructor) {
        this.instructor = instructor;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Double getTour_full_time() {
        return tour_full_time;
    }

    public void setTour_full_time(Double tour_full_time) {
        this.tour_full_time = tour_full_time;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute_length() {
        return route_length;
    }

    public void setRoute_length(String route_length) {
        this.route_length = route_length;
    }

    public LocalDateTime getTour_date() {
        return tour_date;
    }

    public void setTour_date(LocalDateTime tour_date) {
        this.tour_date = tour_date;
    }

    public TourType getTour_type() {
        return tour_type;
    }

    public void setTour_type(TourType tour_type) {
        this.tour_type = tour_type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
