package edu.ccrm.domain;

// ...existing code...

public class Instructor extends Person {
    private String department;

    public Instructor(String id, String fullName, String email, String status, String department) {
        super(id, fullName, email, status);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public void printProfile() {
        System.out.println("Instructor Profile:");
        System.out.println(this);
        System.out.println("Department: " + department);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Department: %s", department);
    }
}
