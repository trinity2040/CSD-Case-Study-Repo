package com.cts.service.impl;


import com.cts.dao.AttendanceDAO;
import com.cts.dao.impl.AttendanceDAOImpl;
import com.cts.exception.DuplicateAttendanceException;
import com.cts.model.Attendance;
import com.cts.service.AttendanceService;
import com.cts.exception.AttendanceNotFoundException;

import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceDAO attendanceDAO;

    public AttendanceServiceImpl() {
        this.attendanceDAO = new AttendanceDAOImpl();
    }

    @Override
    public void addAttendance(Attendance attendance) {
        try {
            attendanceDAO.addAttendance(attendance);
        } catch (DuplicateAttendanceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        if (attendanceDAO.getAttendanceById(attendance.getAttendanceId()) == null) {
            throw new AttendanceNotFoundException("Attendance record not found with ID: " + attendance.getAttendanceId());
        }
        attendanceDAO.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendance(int attendanceId) {
        if (attendanceDAO.getAttendanceById(attendanceId) == null) {
            throw new AttendanceNotFoundException("Attendance record not found with ID: " + attendanceId);
        }
        attendanceDAO.deleteAttendance(attendanceId);
    }

    @Override
    public Attendance getAttendanceById(int attendanceId) {
        Attendance attendance = attendanceDAO.getAttendanceById(attendanceId);
        if (attendance == null) {
            throw new AttendanceNotFoundException("Attendance record not found with ID: " + attendanceId);
        }
        return attendance;
    }

    @Override
    public List<Attendance> getAttendancesByEmployeeId(int employeeId) {
        return attendanceDAO.getAttendancesByEmployeeId(employeeId);
    }

    @Override
    public List<Attendance> getMonthlyAttendanceReport(int employeeId, String monthYear) {
        return attendanceDAO.getMonthlyAttendanceReport(employeeId, monthYear);
    }

    @Override
    public List<Attendance> getDailyAttendanceReport() {
        return attendanceDAO.getDailyAttendanceReport();
    }
}

