package com.cts.dao;


import com.cts.exception.DuplicateAttendanceException;
import com.cts.model.Attendance;
import java.util.List;

public interface AttendanceDAO {
    void addAttendance(Attendance attendance) throws DuplicateAttendanceException;
    void updateAttendance(Attendance attendance);
    void deleteAttendance(int attendanceId);
    Attendance getAttendanceById(int attendanceId);
    List<Attendance> getAttendancesByEmployeeId(int employeeId);
    List<Attendance> getMonthlyAttendanceReport(int employeeId, String monthYear); 
    List<Attendance> getDailyAttendanceReport(); 
}
