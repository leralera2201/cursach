package edu.lera.cursach.form;

public class TourTypeForm {
    private String id;
    private String type_name;
    private String type_description;

    public TourTypeForm() {
    }

    public TourTypeForm(String id, String type_name, String type_description) {
        this.id = id;
        this.type_name = type_name;
        this.type_description = type_description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }
}
