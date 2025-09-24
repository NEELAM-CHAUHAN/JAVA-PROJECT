package edu.ccrm.io;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ImportExportService {
    public List<Student> importStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                // regNo, name, email, status
                Student s = new Student(parts[1], parts[2], parts[3], parts[0]);
                students.add(s);
            }
        }
        return students;
    }

    public void exportStudents(List<Student> students, String filePath) throws IOException {
        List<String> lines = students.stream()
            .map(s -> String.join(",", s.getRegNo(), s.getFullName(), s.getEmail(), s.getStatus()))
            .collect(Collectors.toList());
        Files.write(Paths.get(filePath), lines);
    }

    public List<Course> importCourses(String filePath) throws IOException {
        List<Course> courses = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 6) {
                // For simplicity, instructor and semester are not parsed in detail here
                Course c = new Course(parts[0], parts[1], Integer.parseInt(parts[2]), null, null, parts[5]);
                courses.add(c);
            }
        }
        return courses;
    }

    public void exportCourses(List<Course> courses, String filePath) throws IOException {
        List<String> lines = courses.stream()
            .map(c -> String.join(",", c.getCode(), c.getTitle(), String.valueOf(c.getCredits()), "", "", c.getDepartment()))
            .collect(Collectors.toList());
        Files.write(Paths.get(filePath), lines);
    }
}
