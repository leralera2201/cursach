package edu.lera.cursach.form;

import edu.lera.cursach.model.Tourist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CoachForm {
    private String id;
    private String speciality;
    private String tourist;
    private String salary;
    private String started_work_year;

    public CoachForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStarted_work_year() {
        return started_work_year;
    }

    public void setStarted_work_year(String started_work_year) {
        this.started_work_year = started_work_year;
    }

    public CoachForm(String id, String speciality, String tourist, String salary, String started_work_year) {
        this.id = id;
        this.speciality = speciality;
        this.tourist = tourist;
        this.salary = salary;
        this.started_work_year = started_work_year;
    }
}
