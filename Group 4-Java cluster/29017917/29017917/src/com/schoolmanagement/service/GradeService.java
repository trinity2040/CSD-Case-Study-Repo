package com.schoolmanagement.service;

import com.schoolmanagement.dao.GradeDAO;
import com.schoolmanagement.model.Grade;

import java.util.List;

public class GradeService {
    private GradeDAO gradeDAO = new GradeDAO();

    public void addGrade(Grade grade) {
        gradeDAO.addGrade(grade);
    }

    public Grade getGrade(int gradeId) {
        return gradeDAO.getGrade(gradeId);
    }

    public void updateGrade(Grade grade) {
        gradeDAO.updateGrade(grade);
    }

    public void deleteGrade(int gradeId) {
        gradeDAO.deleteGrade(gradeId);
    }

    public List<Grade> getAllGrades() {
        return gradeDAO.getAllGrades();
    }

    public double calculateGPA(int studentId) {
        return gradeDAO.calculateGPA(studentId);
    }
}
