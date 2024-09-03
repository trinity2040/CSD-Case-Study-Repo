package com.schoolmanagement.dao;

import com.schoolmanagement.model.Grade;
import com.schoolmanagement.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    public void addGrade(Grade grade) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Grade(student_id, course_id, grade) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getCourseId());
            preparedStatement.setString(3, grade.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Grade getGrade(int gradeId) {
        Grade grade = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Grade WHERE grade_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, gradeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                grade = new Grade();
                grade.setGradeId(resultSet.getInt("grade_id"));
                grade.setStudentId(resultSet.getInt("student_id"));
                grade.setCourseId(resultSet.getInt("course_id"));
                grade.setGrade(resultSet.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    public void updateGrade(Grade grade) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Grade SET student_id = ?, course_id = ?, grade = ? WHERE grade_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, grade.getStudentId());
            preparedStatement.setInt(2, grade.getCourseId());
            preparedStatement.setString(3, grade.getGrade());
            preparedStatement.setInt(4, grade.getGradeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGrade(int gradeId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Grade WHERE grade_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, gradeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Grade";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setGradeId(resultSet.getInt("grade_id"));
                grade.setStudentId(resultSet.getInt("student_id"));
                grade.setCourseId(resultSet.getInt("course_id"));
                grade.setGrade(resultSet.getString("grade"));
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

//     public double calculateGPA(int studentId) {
//         double gpa = 0.0;
//         try (Connection connection = DatabaseConnection.getConnection()) {
//             String query = "SELECT AVG(grade) as gpa FROM Grade WHERE student_id = ?";
//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             preparedStatement.setInt(1, studentId);
//             ResultSet resultSet = preparedStatement.executeQuery();

//             if (resultSet.next()) {
//                 gpa = resultSet.getDouble("gpa");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return gpa;
//     }
// }

public double calculateGPA(int studentId) {
    double gpa = 0.0;
    int gradeCount = 0;
    
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "SELECT grade FROM Grade WHERE student_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, studentId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String grade = resultSet.getString("grade");
            gpa += mapGradeToGPA(grade);
            gradeCount++;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return (gradeCount > 0) ? gpa / gradeCount : 0.0;
}

private double mapGradeToGPA(String grade) {
    switch (grade) {
        case "O": return 9.5; // Adjusted average for O grade
        case "A": return 8.5; // Adjusted average for A grade
        case "B": return 7.5; // Adjusted average for B grade
        case "C": return 6.5; // Adjusted average for C grade
        case "D": return 5.5; // Adjusted average for D grade
        case "F": return 4.5; // Adjusted average for F grade
        default: return 0.0; // In case of an unknown grade
    }
}

}