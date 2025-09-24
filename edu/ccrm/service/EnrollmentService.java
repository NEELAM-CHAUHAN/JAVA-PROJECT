package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Grade;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    private static final int MAX_CREDITS_PER_SEMESTER = 24;

    public boolean enrollStudent(Student student, Course course, Semester semester) {
        int totalCredits = enrollments.stream()
            .filter(e -> e.getStudent().equals(student) && e.getSemester() == semester)
            .mapToInt(e -> e.getCourse().getCredits())
            .sum();
        if (totalCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            return false; // Max credit limit exceeded
        }
        Enrollment enrollment = new Enrollment(student, course, semester);
        enrollments.add(enrollment);
        student.enrollCourse(course.getCode());
        return true;
    }

    public void unenrollStudent(Student student, Course course, Semester semester) {
        enrollments.removeIf(e -> e.getStudent().equals(student) && e.getCourse().equals(course) && e.getSemester() == semester);
        student.unenrollCourse(course.getCode());
    }

    public void recordGrade(Student student, Course course, Semester semester, Grade grade) {
        for (Enrollment e : enrollments) {
            if (e.getStudent().equals(student) && e.getCourse().equals(course) && e.getSemester() == semester) {
                e.setGrade(grade);
            }
        }
    }

    public List<Enrollment> getEnrollmentsForStudent(Student student) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudent().equals(student)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
