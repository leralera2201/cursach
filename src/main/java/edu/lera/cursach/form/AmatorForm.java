package edu.lera.cursach.form;

import edu.lera.cursach.model.Tourist;

public class AmatorForm {

    private String id;
    private String hobbies;
    private String tourist;

    public AmatorForm() {
    }

    public AmatorForm(String id, String hobbies, String tourist) {
        this.id = id;
        this.hobbies = hobbies;
        this.tourist = tourist;
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

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }

}
