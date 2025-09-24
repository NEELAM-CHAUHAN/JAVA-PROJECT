package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> listStudents() {
        return students;
    }

    public Student findStudentByRegNo(String regNo) {
        for (Student s : students) {
            if (s.getRegNo().equals(regNo)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(String regNo, String newName, String newEmail) {
        Student s = findStudentByRegNo(regNo);
        if (s != null) {
            s.setFullName(newName);
            s.setEmail(newEmail);
        }
    }

    public void deactivateStudent(String regNo) {
        Student s = findStudentByRegNo(regNo);
        if (s != null) {
            s.setStatus("Inactive");
        }
    }
}
