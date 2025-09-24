package edu.ccrm.domain;

import java.time.LocalDate;

public abstract class Person {
    private String id;
    private String fullName;
    private String email;
    private String status;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public Person(String id, String fullName, String email, String status) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.status = status;
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getUpdatedDate() { return updatedDate; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setStatus(String status) { this.status = status; }
    public void setUpdatedDate(LocalDate updatedDate) { this.updatedDate = updatedDate; }

    public abstract void printProfile();

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Email: %s, Status: %s", id, fullName, email, status);
    }
}
