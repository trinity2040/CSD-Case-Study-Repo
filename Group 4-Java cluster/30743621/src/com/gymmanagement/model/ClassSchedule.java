package com.gymmanagement.model;

/**
 * The ClassSchedule class represents a gym class with attributes such as scheduleId, className,
 * trainerId, dayOfWeek, startTime and endTime. This class serves as a model in the gym
 * management system and includes standard getters and setters for these attributes.
 * 
 * Usage:
 * - This class can be used to store and retrieve information about gym classes.
 */
import java.time.LocalTime;

public class ClassSchedule {
	private int scheduleId,trainerId;
    private String className,dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    
//	getters and setters
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}