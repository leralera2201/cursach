package edu.lera.cursach.form;

public class CategoryForm {
    private String category_name;
    private String category_mark;
    private String more_than;

    public CategoryForm() {
    }

    public CategoryForm(String category_name, String category_mark, String more_than) {
        this.category_name = category_name;
        this.category_mark = category_mark;
        this.more_than = more_than;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_mark() {
        return category_mark;
    }

    public void setCategory_mark(String category_mark) {
        this.category_mark = category_mark;
    }

    public String getMore_than() {
        return more_than;
    }

    public void setMore_than(String more_than) {
        this.more_than = more_than;
    }
}
