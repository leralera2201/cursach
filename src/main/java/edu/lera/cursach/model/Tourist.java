package edu.lera.cursach.model;



import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tourist {
    @Id
    private String id;
    private String surname;
    private String name;
    private String patronic;
    private String negative_features;
    private String phone;
    private LocalDate birthday;
    private String email;
    private Category max_category;
    private Boolean sex;    //true - man, false - woman
    private String physical_data;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Tourist() {
    }

    public Tourist(String id, String surname, String name, String patronic, String negative_features, String phone, LocalDate birthday, String email, Category max_category, Boolean sex, LocalDateTime created_date, LocalDateTime modified_date, String physical_data) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronic = patronic;
        this.negative_features = negative_features;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.max_category = max_category;
        this.sex = sex;

        this.created_date = created_date;
        this.modified_date = modified_date;
        this.physical_data = physical_data;
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

    public String getNegative_features() {
        return negative_features;
    }

    public void setNegative_features(String negative_features) {
        this.negative_features = negative_features;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Category getMax_category() {
        return max_category;
    }

    public void setMax_category(Category max_category) {
        this.max_category = max_category;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
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

    public String getPhysical_data() {
        return physical_data;
    }

    public void setPhysical_data(String physical_data) {
        this.physical_data = physical_data;
    }
    public String getNameandSurname(){
        return this.getName() + ' ' + this.getSurname();
    }
}
