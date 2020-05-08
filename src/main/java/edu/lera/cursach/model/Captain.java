package edu.lera.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Document
public class Captain {
    @Id
    private String id;
    private String surname;
    private String name;
    private String patronic;
    private LocalDate birthday;
    private LocalDate started_work_year;
    private Double salary;
    private String email;
    private String phone;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private Boolean sex;    //man - true, woman - false

    public Captain() {
    }



    public Captain(String id, String surname, String name, String patronic, LocalDate birthday, LocalDate started_work_year, Double salary, String email, String phone, LocalDateTime created_date, LocalDateTime modified_date, Boolean sex) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronic = patronic;
        this.birthday = birthday;
        this.started_work_year = started_work_year;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.created_date = created_date;
        this.modified_date = modified_date;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronic() {
        return patronic;
    }

    public void setPatronic(String patronic) {
        this.patronic = patronic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStarted_work_year() {
        return started_work_year;
    }

    public void setStarted_work_year(LocalDate started_work_year) {
        this.started_work_year = started_work_year;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public String getNameAndSurname() {
        return this.name + ' ' + this.surname;
    }
}
