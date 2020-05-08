package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Schedule {
    private String id;
    private LocalDateTime started_datetime;
    private Double time;
    private String trainName;
    private String description; //kind of train
    private Double payment;
    private Group group;
    private String place;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Schedule() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStarted_datetime() {
        return started_datetime;
    }

    public void setStarted_datetime(LocalDateTime started_datetime) {
        this.started_datetime = started_datetime;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getTrain_name() {
        return trainName;
    }

    public void setTrain_name(String trainName) {
        this.trainName = trainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public Schedule(String id, LocalDateTime started_datetime, Double time, String trainName, String description, Double payment, Group group, String place, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.started_datetime = started_datetime;
        this.time = time;
        this.trainName = trainName;
        this.description = description;
        this.payment = payment;
        this.group = group;
        this.place = place;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }
}
