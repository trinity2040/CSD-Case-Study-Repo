package com.schoolmanagement;

import com.schoolmanagement.model.*;
import com.schoolmanagement.service.*;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();
    private CourseService courseService = new CourseService();
    private GradeService gradeService = new GradeService();

    public void displayMenu() {
        while (true) {
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Course Management");
            System.out.println("4. Grade Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentManagement();
                    break;
                case 2:
                    teacherManagement();
                    break;
                case 3:
                    courseManagement();
                    break;
                case 4:
                    gradeManagement();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void studentManagement() {
        System.out.println("1. Add Student");
        System.out.println("2. View Student Details");
        System.out.println("3. Update Student Information");
        System.out.println("4. Delete Student");
        System.out.println("5. View All Students");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                viewStudent();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                viewAllStudents();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addStudent() {
        Student student = new Student();
        System.out.print("Enter name: ");
        student.setName(scanner.next());
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        student.setDateOfBirth(scanner.next());
        System.out.print("Enter address: ");
        student.setAddress(scanner.next());
        System.out.print("Enter email: ");
        student.setEmail(scanner.next());
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private void viewStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        Student student = studentService.getStudent(studentId);
        if (student != null) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        Student student = studentService.getStudent(studentId);
        if (student != null) {
            System.out.print("Enter new name: ");
            student.setName(scanner.next());
            System.out.print("Enter new date of birth (YYYY-MM-DD): ");
            student.setDateOfBirth(scanner.next());
            System.out.print("Enter new address: ");
            student.setAddress(scanner.next());
            System.out.print("Enter new email: ");
            student.setEmail(scanner.next());
            studentService.updateStudent(student);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        studentService.deleteStudent(studentId);
        System.out.println("Student deleted successfully!");
    }

    private void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Email: " + student.getEmail());
            System.out.println("-------------------------------------");
        }
    }

    private void teacherManagement() {
        System.out.println("1. Add Teacher");
        System.out.println("2. View Teacher Details");
        System.out.println("3. Update Teacher Information");
        System.out.println("4. Delete Teacher");
        System.out.println("5. View All Teachers");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addTeacher();
                break;
            case 2:
                viewTeacher();
                break;
            case 3:
                updateTeacher();
                break;
            case 4:
                deleteTeacher();
                break;
            case 5:
                viewAllTeachers();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addTeacher() {
        Teacher teacher = new Teacher();
        System.out.print("Enter name: ");
        teacher.setName(scanner.next());
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.next();
    
        // Validate the date format
        if (dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            teacher.setDateOfBirth(dob);
        } else {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        }
    
        System.out.print("Enter address: ");
        teacher.setAddress(scanner.next());
        System.out.print("Enter email: ");
        teacher.setEmail(scanner.next());
        teacherService.addTeacher(teacher);
        System.out.println("Teacher added successfully!");
    }

    private void viewTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        Teacher teacher = teacherService.getTeacher(teacherId);
        if (teacher != null) {
            System.out.println("Teacher ID: " + teacher.getTeacherId());
            System.out.println("Name: " + teacher.getName());
            System.out.println("Date of Birth: " + teacher.getDateOfBirth());
            System.out.println("Address: " + teacher.getAddress());
            System.out.println("Email: " + teacher.getEmail());
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void updateTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        Teacher teacher = teacherService.getTeacher(teacherId);
        if (teacher != null) {
            System.out.print("Enter new name: ");
            teacher.setName(scanner.next());
            System.out.print("Enter new date of birth (YYYY-MM-DD): ");
            teacher.setDateOfBirth(scanner.next());
            System.out.print("Enter new address: ");
            teacher.setAddress(scanner.next());
            System.out.print("Enter new email: ");
            teacher.setEmail(scanner.next());
            teacherService.updateTeacher(teacher);
            System.out.println("Teacher updated successfully!");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void deleteTeacher() {
        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        teacherService.deleteTeacher(teacherId);
        System.out.println("Teacher deleted successfully!");
    }

    private void viewAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println("Teacher ID: " + teacher.getTeacherId());
            System.out.println("Name: " + teacher.getName());
            System.out.println("Date of Birth: " + teacher.getDateOfBirth());
            System.out.println("Address: " + teacher.getAddress());
            System.out.println("Email: " + teacher.getEmail());
            System.out.println("-------------------------------------");
        }
    }

    private void courseManagement() {
        System.out.println("1. Add Course");
        System.out.println("2. View Course Details");
        System.out.println("3. Update Course Information");
        System.out.println("4. Delete Course");
        System.out.println("5. View All Courses");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addCourse();
                break;
            case 2:
                viewCourse();
                break;
            case 3:
                updateCourse();
                break;
            case 4:
                deleteCourse();
                break;
            case 5:
                viewAllCourses();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addCourse() {
        Course course = new Course();
        System.out.print("Enter title: ");
        course.setTitle(scanner.next());
        System.out.print("Enter description: ");
        course.setDescription(scanner.next());
        System.out.print("Enter teacher ID: ");
        course.setTeacherId(scanner.nextInt());
        courseService.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private void viewCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Teacher ID: " + course.getTeacherId());
        } else {
            System.out.println("Course not found.");
        }
    }

    private void updateCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            System.out.print("Enter new title: ");
            course.setTitle(scanner.next());
            System.out.print("Enter new description: ");
            course.setDescription(scanner.next());
            System.out.print("Enter new teacher ID: ");
            course.setTeacherId(scanner.nextInt());
            courseService.updateCourse(course);
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Course not found.");
        }
    }

    private void deleteCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        courseService.deleteCourse(courseId);
        System.out.println("Course deleted successfully!");
    }

    private void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        for (Course course : courses) {
            System.out.println("Course ID: " + course.getCourseId());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Teacher ID: " + course.getTeacherId());
            System.out.println("-------------------------------------");
        }
    }

    private void gradeManagement() {
        System.out.println("1. Add Grade");
        System.out.println("2. View Grade Details");
        System.out.println("3. Update Grade Information");
        System.out.println("4. Delete Grade");
        System.out.println("5. View All Grades");
        System.out.println("6. Calculate GPA");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addGrade();
                break;
            case 2:
                viewGrade();
                break;
            case 3:
                updateGrade();
                break;
            case 4:
                deleteGrade();
                break;
            case 5:
                viewAllGrades();
                break;
            case 6:
                calculateGPA();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addGrade() {
        Grade grade = new Grade();
        System.out.print("Enter student ID: ");
        grade.setStudentId(scanner.nextInt());
        System.out.print("Enter course ID: ");
        grade.setCourseId(scanner.nextInt());
        System.out.print("Enter grade: ");
        grade.setGrade(scanner.next());
        gradeService.addGrade(grade);
        System.out.println("Grade added successfully!");
    }

    private void viewGrade() {
        System.out.print("Enter grade ID: ");
        int gradeId = scanner.nextInt();
        Grade grade = gradeService.getGrade(gradeId);
        if (grade != null) {
            System.out.println("Grade ID: " + grade.getGradeId());
            System.out.println("Student ID: " + grade.getStudentId());
            System.out.println("Course ID: " + grade.getCourseId());
            System.out.println("Grade: " + grade.getGrade());
        } else {
            System.out.println("Grade not found.");
        }
    }

    private void updateGrade() {
        System.out.print("Enter grade ID: ");
        int gradeId = scanner.nextInt();
        Grade grade = gradeService.getGrade(gradeId);
        if (grade != null) {
            System.out.print("Enter new student ID: ");
            grade.setStudentId(scanner.nextInt());
            System.out.print("Enter new course ID: ");
            grade.setCourseId(scanner.nextInt());
            System.out.print("Enter new grade: ");
            grade.setGrade(scanner.next());
            gradeService.updateGrade(grade);
            System.out.println("Grade updated successfully!");
        } else {
            System.out.println("Grade not found.");
        }
    }

    private void deleteGrade() {
        System.out.print("Enter grade ID: ");
        int gradeId = scanner.nextInt();
        gradeService.deleteGrade(gradeId);
        System.out.println("Grade deleted successfully!");
    }

    private void viewAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        for (Grade grade : grades) {
            System.out.println("Grade ID: " + grade.getGradeId());
            System.out.println("Student ID: " + grade.getStudentId());
            System.out.println("Course ID: " + grade.getCourseId());
            System.out.println("Grade: " + grade.getGrade());
            System.out.println("-------------------------------------");
        }
    }

    private void calculateGPA() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        double gpa = gradeService.calculateGPA(studentId);
        System.out.println("GPA: " + gpa);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
