package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> listCourses() {
        return courses;
    }

    public Course findCourseByCode(String code) {
        String searchCode = code.trim().toUpperCase();
        for (Course c : courses) {
            if (c.getCode().trim().toUpperCase().equals(searchCode)) {
                return c;
            }
        }
        return null;
    }

    public void updateCourse(String code, String newTitle, int newCredits, Instructor newInstructor, Semester newSemester, String newDepartment) {
        Course c = findCourseByCode(code);
        if (c != null) {
            c.setTitle(newTitle);
            c.setCredits(newCredits);
            c.setInstructor(newInstructor);
            c.setSemester(newSemester);
            c.setDepartment(newDepartment);
        }
    }

    public void deactivateCourse(String code) {
        Course c = findCourseByCode(code);
        if (c != null) {
            c.setTitle(c.getTitle() + " (Inactive)");
        }
    }

    public List<Course> filterByInstructor(String instructorName) {
        return courses.stream()
            .filter(c -> c.getInstructor().getFullName().equalsIgnoreCase(instructorName))
            .collect(Collectors.toList());
    }

    public List<Course> filterByDepartment(String department) {
        return courses.stream()
            .filter(c -> c.getDepartment().equalsIgnoreCase(department))
            .collect(Collectors.toList());
    }

    public List<Course> filterBySemester(Semester semester) {
        return courses.stream()
            .filter(c -> c.getSemester() == semester)
            .collect(Collectors.toList());
    }
}
