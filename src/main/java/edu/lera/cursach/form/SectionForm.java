package edu.lera.cursach.form;


public class SectionForm {
    private String id;
    private String section_name;
    private String description;
    private String captain;

    public SectionForm(String id, String section_name, String description, String captain) {
        this.id = id;
        this.section_name = section_name;
        this.description = description;
        this.captain = captain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public SectionForm() {
    }
}
