package edu.lera.cursach.model;



import java.time.LocalDateTime;

public class Group {
    private String id;
    private String groupName;
    private String description;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private Section section;
    private Coach coach;
    private Captain assigned_by;

    public Group() {
    }

    public Group(String id, String groupName, String description, LocalDateTime created_date, LocalDateTime modified_date, Section section, Coach coach, Captain assigned_by) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.created_date = created_date;
        this.modified_date = modified_date;
        this.section = section;
        this.coach = coach;
        this.assigned_by = assigned_by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_name() {
        return groupName;
    }

    public void setGroup_name(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Captain getAssigned_by() {
        return assigned_by;
    }

    public void setAssigned_by(Captain assigned_by) {
        this.assigned_by = assigned_by;
    }
}
