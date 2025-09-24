package edu.ccrm.domain;

public class CourseBuilder {
    private String code;
    private String title;
    private int credits;
    private String department;

    public CourseBuilder setCode(String code) {
        this.code = code;
        return this;
    }
    public CourseBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public CourseBuilder setCredits(int credits) {
        this.credits = credits;
        return this;
    }
    public CourseBuilder setDepartment(String department) {
        this.department = department;
        return this;
    }
    public Course build() {
        return new Course(code, title, credits, null, null, department);
    }
}
