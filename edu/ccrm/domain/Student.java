package edu.ccrm.domain;

// ...existing code...
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private List<String> enrolledCourses;

    public Student(String fullName, String email, String status, String regNo) {
        super(regNo, fullName, email, status); // Use regNo as id in Person
        this.regNo = regNo;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getRegNo() { return regNo; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }

    public void enrollCourse(String courseCode) {
        if (!enrolledCourses.contains(courseCode)) {
            enrolledCourses.add(courseCode);
        }
    }

    public void unenrollCourse(String courseCode) {
        enrolledCourses.remove(courseCode);
    }

    @Override
    public void printProfile() {
        System.out.println("Student Profile:");
        System.out.println(this);
        System.out.println("RegNo: " + regNo);
        System.out.println("Enrolled Courses: " + enrolledCourses);
    }

    @Override
    public String toString() {
        return String.format("RegNo: %s, Name: %s, Email: %s, Status: %s", regNo, getFullName(), getEmail(), getStatus());
    }
}
