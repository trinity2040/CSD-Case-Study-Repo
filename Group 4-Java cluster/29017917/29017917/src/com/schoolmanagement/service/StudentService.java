package com.schoolmanagement.service;

import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
