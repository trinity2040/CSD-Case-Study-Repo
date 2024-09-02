package com.schoolmanagement.service;

import com.schoolmanagement.dao.CourseDAO;
import com.schoolmanagement.model.Course;

import java.util.List;

public class CourseService {
    private CourseDAO courseDAO = new CourseDAO();

    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    public Course getCourse(int courseId) {
        return courseDAO.getCourse(courseId);
    }

    public void updateCourse(Course course) {
        courseDAO.updateCourse(course);
    }

    public void deleteCourse(int courseId) {
        courseDAO.deleteCourse(courseId);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
}
