package edu.lera.cursach.form;


public class GroupForm {
    private String id;
    private String group_name;
    private String description;
    private String section;
    private String coach;
    private String assigned_by;

    public GroupForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getAssigned_by() {
        return assigned_by;
    }

    public void setAssigned_by(String assigned_by) {
        this.assigned_by = assigned_by;
    }

    public GroupForm(String id, String group_name, String description, String section, String coach, String assigned_by) {
        this.id = id;
        this.group_name = group_name;
        this.description = description;
        this.section = section;
        this.coach = coach;
        this.assigned_by = assigned_by;
    }
}
