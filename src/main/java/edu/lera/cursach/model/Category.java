package edu.lera.cursach.model;
import java.time.LocalDateTime;

//category of complexity;
public class Category {
    private String id;
    private String categoryName;
    private Integer category_mark;
    private Integer more_than;  //days
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    public Category() {
    }

    public Category(String id, String categoryName, Integer category_mark, Integer more_than, LocalDateTime created_date, LocalDateTime modified_date) {
        this.id = id;
        this.categoryName = categoryName;
        this.category_mark = category_mark;
        this.more_than = more_than;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return categoryName;
    }

    public void setCategory_name(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategory_mark() {
        return category_mark;
    }

    public void setCategory_mark(Integer category_mark) {
        this.category_mark = category_mark;
    }

    public Integer getMore_than() {
        return more_than;
    }

    public void setMore_than(Integer more_than) {
        this.more_than = more_than;
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
}
