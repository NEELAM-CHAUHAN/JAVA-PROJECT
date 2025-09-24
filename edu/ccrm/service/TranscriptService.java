package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
// ...existing code...
import java.util.List;

public class TranscriptService {
    public void printTranscript(Student student, List<Enrollment> enrollments) {
        System.out.println("Transcript for: " + student.getFullName() + " (" + student.getRegNo() + ")");
        double totalPoints = 0;
        int totalCredits = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                int credits = e.getCourse().getCredits();
                int gradePoint = e.getGrade().getGradePoint();
                totalPoints += credits * gradePoint;
                totalCredits += credits;
                System.out.println(e.getCourse().getTitle() + " | " + e.getSemester() + " | Grade: " + e.getGrade() + " | Credits: " + credits);
            }
        }
        double gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;
        System.out.printf("GPA: %.2f\n", gpa);
    }
}
