package edu.lera.cursach.form;

import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Group;
import edu.lera.cursach.model.TourType;
import edu.lera.cursach.model.Tourist;

import java.time.LocalDateTime;

public class TourForm {
    private String id;
    private String tour_name;
    private String tour_description;
    private String instructor;
    private String group;
    private String tour_full_time;
    private String payment;
    private String route;
    private String route_length;
    private String tour_date;
    private String tour_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getTour_description() {
        return tour_description;
    }

    public void setTour_description(String tour_description) {
        this.tour_description = tour_description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTour_full_time() {
        return tour_full_time;
    }

    public void setTour_full_time(String tour_full_time) {
        this.tour_full_time = tour_full_time;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
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

    public String getTour_date() {
        return tour_date;
    }

    public void setTour_date(String tour_date) {
        this.tour_date = tour_date;
    }

    public String getTour_type() {
        return tour_type;
    }

    public void setTour_type(String tour_type) {
        this.tour_type = tour_type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public TourForm() {
    }

    public TourForm(String id, String tour_name, String tour_description, String instructor, String group, String tour_full_time, String payment, String route, String route_length, String tour_date, String tour_type, String category) {
        this.id = id;
        this.tour_name = tour_name;
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
    }
}
