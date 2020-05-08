package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class Amator {
    private String id;
    private String hobbies;
    private Tourist tourist;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Amator() {
    }

    public Amator(String id, String hobbies, Tourist tourist, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.hobbies = hobbies;
        this.tourist = tourist;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
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

    public String getName(){
        return this.getTourist().getName();
    }

}

