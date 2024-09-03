package com.cts.service;


import com.cts.model.Attendance;

import java.util.List;

public interface AttendanceService {
    void addAttendance(Attendance attendance);
    void updateAttendance(Attendance attendance);
    void deleteAttendance(int attendanceId);
    Attendance getAttendanceById(int attendanceId);
    List<Attendance> getAttendancesByEmployeeId(int employeeId);
    List<Attendance> getMonthlyAttendanceReport(int employeeId, String monthYear); 
    List<Attendance> getDailyAttendanceReport();
}

