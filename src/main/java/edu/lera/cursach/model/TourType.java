package edu.lera.cursach.model;

import java.time.LocalDateTime;

public class TourType {
    private String id;
    private String typeName;
    private String type_description;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public TourType() {
    }

    public TourType(String id, String typeName, String type_description, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.typeName = typeName;
        this.type_description = type_description;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_name() {
        return typeName;
    }

    public void setType_name(String typeName) {
        this.typeName = typeName;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
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
