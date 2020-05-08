package edu.lera.cursach.form;


public class TouristInGroupForm {
    private String id;
    private String group;
    private String tourist;

    public TouristInGroupForm() {
    }

    public TouristInGroupForm(String id, String group, String tourist) {
        this.id = id;
        this.group = group;
        this.tourist = tourist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }
}
