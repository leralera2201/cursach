package edu.lera.cursach.form;

public class TouristForm {

    private String id;
    private String surname;
    private String name;
    private String patronic;
    private String negative_features;
    private String phone;
    private String birthday;
    private String email;
    private String max_category;
    private String sex;    //true - man, false - woman
    private String physical_data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TouristForm() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMax_category() {
        return max_category;
    }

    public void setMax_category(String max_category) {
        this.max_category = max_category;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhysical_data() {
        return physical_data;
    }

    public void setPhysical_data(String physical_data) {
        this.physical_data = physical_data;
    }

    public TouristForm(String id, String surname, String name, String patronic, String negative_features, String phone, String birthday, String email, String max_category, String sex, String physical_data) {
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
        this.physical_data = physical_data;
    }
}
