package edu.lera.cursach.form;


public class ScheduleForm {
    private String id;
    private String started_datetime;
    private String time;
    private String train_name;
    private String description; //kind of train
    private String payment;
    private String group;
    private String place;

    public ScheduleForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStarted_datetime() {
        return started_datetime;
    }

    public void setStarted_datetime(String started_datetime) {
        this.started_datetime = started_datetime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ScheduleForm(String id, String started_datetime, String time, String train_name, String description, String payment, String group, String place) {
        this.id = id;
        this.started_datetime = started_datetime;
        this.time = time;
        this.train_name = train_name;
        this.description = description;
        this.payment = payment;
        this.group = group;
        this.place = place;
    }
}
