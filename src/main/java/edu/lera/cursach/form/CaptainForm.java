package edu.lera.cursach.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CaptainForm {
    private String id;
    private String surname;
    private String name;
    private String patronic;
    private String birthday;
    private String started_work_year;
    private String salary;
    private String email;
    private String phone;
    private String sex;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStarted_work_year() {
        return started_work_year;
    }

    public void setStarted_work_year(String started_work_year) {
        this.started_work_year = started_work_year;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public CaptainForm() {
    }

    public CaptainForm(String id, String surname, String name, String patronic, String birthday, String started_work_year, String salary, String email, String phone, String sex) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronic = patronic;
        this.birthday = birthday;
        this.started_work_year = started_work_year;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }
}
