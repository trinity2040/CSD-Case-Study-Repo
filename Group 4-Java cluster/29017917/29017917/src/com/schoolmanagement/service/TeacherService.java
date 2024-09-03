package com.schoolmanagement.service;

import com.schoolmanagement.dao.TeacherDAO;
import com.schoolmanagement.model.Teacher;

import java.util.List;

public class TeacherService {
    private TeacherDAO teacherDAO = new TeacherDAO();

    public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    public Teacher getTeacher(int teacherId) {
        return teacherDAO.getTeacher(teacherId);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDAO.updateTeacher(teacher);
    }

    public void deleteTeacher(int teacherId) {
        teacherDAO.deleteTeacher(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
}
