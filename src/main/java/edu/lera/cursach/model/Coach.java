package edu.lera.cursach.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Coach {
    private String id;
    private String speciality;
    private Tourist tourist;
    private Double salary;
    private LocalDate started_work_year;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Coach() {
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

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getStarted_work_year() {
        return started_work_year;
    }

    public void setStarted_work_year(LocalDate started_work_year) {
        this.started_work_year = started_work_year;
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

    public Coach(String id, String speciality, Tourist tourist, Double salary, LocalDate started_work_year, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.speciality = speciality;
        this.tourist = tourist;
        this.salary = salary;
        this.started_work_year = started_work_year;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }
    public  String getTouristNameAndSurname() {
        return this.getTourist().getNameandSurname();
    }

    public  String getName() {
        return this.getTourist().getName();
    }

}
