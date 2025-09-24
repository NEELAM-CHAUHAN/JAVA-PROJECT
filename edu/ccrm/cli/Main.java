package edu.ccrm.cli;

import edu.ccrm.service.StudentService;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;
import edu.ccrm.util.Validator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        System.out.println("Welcome to Campus Course & Records Manager (CCRM)");
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Add Course");
            System.out.println("4. List Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Registration No: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    if (!Validator.isNonEmpty(regNo) || !Validator.isNonEmpty(name) || !Validator.isValidEmail(email) || !Validator.isNonEmpty(status)) {
                        System.out.println("Invalid input. Please enter valid registration number, name, email, and status.");
                        break;
                    }
                    Student student = new Student(name, email, status, regNo);
                    studentService.addStudent(student);
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.println("Students:");
                    for (Student s : studentService.listStudents()) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    String instructorName = scanner.nextLine();
                    System.out.print("Enter Instructor Email: ");
                    String instructorEmail = scanner.nextLine();
                    System.out.print("Enter Instructor Status: ");
                    String instructorStatus = scanner.nextLine();
                    System.out.print("Enter Instructor Department: ");
                    String instructorDept = scanner.nextLine();
                    Instructor instructor = new Instructor("I1", instructorName, instructorEmail, instructorStatus, instructorDept);
                    System.out.print("Enter Semester (SPRING/SUMMER/FALL): ");
                    String semStr = scanner.nextLine().toUpperCase();
                    Semester semester = Semester.valueOf(semStr);
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    Course course = new Course(code, title, credits, instructor, semester, dept);
                    courseService.addCourse(course);
                    System.out.println("Course added.");
                    break;
                case 4:
                    System.out.println("Courses:");
                    for (Course c : courseService.listCourses()) {
                        System.out.println(c);
                    }
                    break;
                case 5:
                    System.out.print("Enter Student RegNo: ");
                    String enrollRegNo = scanner.nextLine();
                    Student enrollStudent = studentService.findStudentByRegNo(enrollRegNo);
                    if (enrollStudent == null) {
                        System.out.println("Student not found. Please enter student details to add:");
                        System.out.print("Enter Full Name: ");
                        String enrollName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String enrollEmail = scanner.nextLine();
                        System.out.print("Enter Status: ");
                        String enrollStatus = scanner.nextLine();
                        if (!Validator.isNonEmpty(enrollRegNo) || !Validator.isNonEmpty(enrollName) || !Validator.isValidEmail(enrollEmail) || !Validator.isNonEmpty(enrollStatus)) {
                            System.out.println("Invalid input. Please enter valid registration number, name, email, and status.");
                            break;
                        }
                        enrollStudent = new Student(enrollName, enrollEmail, enrollStatus, enrollRegNo);
                        studentService.addStudent(enrollStudent);
                        System.out.println("Student added.");
                    }
                    System.out.print("Enter Course Code: ");
                    String enrollCourseCode = scanner.nextLine();
                    Course enrollCourse = courseService.findCourseByCode(enrollCourseCode);
                    if (enrollCourse == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    System.out.print("Enter Semester (SPRING/SUMMER/FALL): ");
                    String enrollSemStr = scanner.nextLine().toUpperCase();
                    Semester enrollSemester = Semester.valueOf(enrollSemStr);
                    boolean enrolled = enrollmentService.enrollStudent(enrollStudent, enrollCourse, enrollSemester);
                    if (enrolled) {
                        System.out.println("Enrollment successful.");
                    } else {
                        System.out.println("Max credit limit exceeded for this semester.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
