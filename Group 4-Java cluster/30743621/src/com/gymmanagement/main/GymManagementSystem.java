package com.gymmanagement.main;

import com.gymmanagement.dao.*;
import com.gymmanagement.model.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
* The GymManagementSystem class serves as the main entry point for the gym management system.
* It provides a command-line interface for managing gym members, trainers, and class schedules.
* Users can perform various operations such as registering new members, updating trainer information,
* creating and viewing class schedules, and more.
*/
public class GymManagementSystem {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		MemberDAO memberDAO = new MemberDAO();
		TrainerDAO trainerDAO = new TrainerDAO();
		ClassScheduleDAO classScheduleDAO = new ClassScheduleDAO();
		
		while (true) {
			System.out.println("----- Welcome to our Gym Management System -----");
			System.out.println();
            System.out.println("1. Manage Members");
            System.out.println("2. Manage Trainers");
            System.out.println("3. Manage Class Schedules");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
//                	for managing Members
                    manageMembers(sc,memberDAO);
                    break;
                case 2:
//                	for managing Trainers
                    manageTrainers(sc,trainerDAO);
                    break;
                case 3:
//                	for managing Classes
                    manageClassSchedules(sc,classScheduleDAO);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
//	This function deals with all functionalities of class Schedule Management
	private static void manageClassSchedules(Scanner sc,ClassScheduleDAO classScheduleDAO) {
		while (true) {
			System.out.println("----- Class Schedule Management -----");
            System.out.println("1. Create Class Schedule");
            System.out.println("2. View Class Schedules");
            System.out.println("3. Update Class Schedule");
            System.out.println("4. Delete Class Schedule");
            System.out.println("5. View Class Schedule based on schedule Id");
            System.out.println("6. Go Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	ClassSchedule newClass = new ClassSchedule();
                    System.out.println("Enter class name: ");
                    newClass.setClassName(sc.nextLine());
                    System.out.println("Enter Trainer Id: ");
                    newClass.setTrainerId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter Day of Week: ");
                    newClass.setDayOfWeek(sc.nextLine());
                    System.out.println("Enter start Time (in HH:mm:ss format): ");
                    String time=sc.nextLine();
                    LocalTime start=LocalTime.parse(time,DateTimeFormatter.ofPattern("HH:mm:ss"));
                    newClass.setStartTime(start);
                    
                    System.out.println("Enter end Time (in HH:mm:ss format): ");
                    String time1=sc.nextLine();
                    LocalTime end=LocalTime.parse(time1,DateTimeFormatter.ofPattern("HH:mm:ss"));
                    newClass.setEndTime(end);
                    classScheduleDAO.addClassSchedule(newClass);
                    System.out.println("Schedule added Successfully");
                    System.out.println();
                    break;
                    
                case 2:
                    List<ClassSchedule> classes=classScheduleDAO.getAllClassSchedules();
                    System.out.println("Class Details:");
                	for(ClassSchedule class1:classes) {
                		if (class1 != null) {
                			System.out.println("Schedule Id: " +class1.getScheduleId()+", Class Name: "+class1.getClassName());
                            System.out.println("Trainer ID: " +class1.getTrainerId()+", Day of Week: "+class1.getDayOfWeek());
                            System.out.println("Start Time: " +class1.getStartTime());
                            System.out.println("End Time: " +class1.getEndTime());
                        } else {
                            System.out.println("Class not found.");
                        }
                		System.out.println();
                	}
                    break;
                    
                case 3:
                	System.out.println("Enter Schedule ID to update: ");
                    int scheduleIdToUpdate = sc.nextInt();
                    sc.nextLine(); 
                    ClassSchedule scheduleToUpdate = classScheduleDAO.getClass(scheduleIdToUpdate);
                    
                    if(scheduleToUpdate!=null) {
                    	System.out.println("Enter New Class name: ");
                        scheduleToUpdate.setClassName(sc.nextLine());
                        System.out.println("Enter New Trainer Id: ");
                        scheduleToUpdate.setTrainerId(sc.nextInt());
                        System.out.println("Enter New Day Of Week: ");
                        scheduleToUpdate.setDayOfWeek(sc.nextLine());
                        System.out.println("Enter New start Time (in HH:mm:ss format): ");
                        String time11=sc.nextLine();
                        LocalTime start1=LocalTime.parse(time11,DateTimeFormatter.ofPattern("HH:mm:ss"));
                        scheduleToUpdate.setStartTime(start1);
                        
                        System.out.println("Enter New end Time (in HH:mm:ss format): ");
                        String time12=sc.nextLine();
                        LocalTime end1=LocalTime.parse(time12,DateTimeFormatter.ofPattern("HH:mm:ss"));
                        scheduleToUpdate.setStartTime(end1);
                        
                        classScheduleDAO.updateClassSchedule(scheduleToUpdate);
                        System.out.println("Schedule updated Successfully");
                        System.out.println();
                    }
                    else {
                    	System.out.println("Class not found");
                    	System.out.println();
                    }
                    
                    break;
                    
                case 4:
                	System.out.println("Enter ScheduleId: ");
                    int scheduleId1 = sc.nextInt();
                    classScheduleDAO.deleteClassSchedule(scheduleId1);
                    System.out.println("Scheduled deleted Successfully");
                    System.out.println();
                    break;
                    
                case 5:
                	System.out.println("Enter Schedule ID: ");
                    int scheduleId = sc.nextInt();
                    sc.nextLine(); 
                    ClassSchedule class1 = classScheduleDAO.getClass(scheduleId);
                    if (class1 != null) {
            			System.out.println("Schedule Id: " +class1.getScheduleId()+", Class Name: "+class1.getClassName());
                        System.out.println("Trainer ID: " +class1.getTrainerId()+", Day of Week: "+class1.getDayOfWeek());
                        System.out.println("Start Time: " +class1.getStartTime());
                        System.out.println("End Time: " +class1.getEndTime());
                    } else {
                        System.out.println("Class not found.");
                    }
            		System.out.println();
                	break;
                    
                case 6:
                	return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
		
		
	}
//	This function deals with all functionalities of Trainer Management
	private static void manageTrainers(Scanner sc,TrainerDAO trainerDAO) {
		while (true) {
			System.out.println("----- Trainer Management -----");
            System.out.println("1. Register Trainer");
            System.out.println("2. Update Trainer");
            System.out.println("3. Delete Trainer");
            System.out.println("4. View all Trainer Details");
            System.out.println("5. View Trainer Details based on trainerId");
            System.out.println("6. Go Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	Trainer newTrainer = new Trainer();
                    System.out.println("Enter name: ");
                    newTrainer.setName(sc.nextLine());
                    System.out.println("Enter contact number: ");
                    newTrainer.setContactNumber(sc.nextLine());
                    System.out.println("Enter email: ");
                    newTrainer.setEmail(sc.nextLine());
                    System.out.println("Enter speciality: ");
                    newTrainer.setSpeciality(sc.nextLine());
                    trainerDAO.addTrainer(newTrainer);
                    System.out.println("Trainer Added Successfully");
                    System.out.println();
                    break;
                    
                case 2:
                	System.out.println("Enter Trainer ID to update: ");
                    int trainerIdToUpdate = sc.nextInt();
                    sc.nextLine(); 
                    Trainer trainerToUpdate = trainerDAO.getTrainer(trainerIdToUpdate);
                    
                    if(trainerToUpdate!=null) {
                    	System.out.println("Enter new name: ");
                        trainerToUpdate.setName(sc.nextLine());
                        System.out.println("Enter new contact number: ");
                        trainerToUpdate.setContactNumber(sc.nextLine());
                        System.out.println("Enter new email: ");
                        trainerToUpdate.setEmail(sc.nextLine());
                        System.out.println("Enter new speciality: ");
                        trainerToUpdate.setSpeciality(sc.nextLine());
                        trainerDAO.updateTrainer(trainerToUpdate);
                        System.out.println("Trainer Updated Successfully");
                        System.out.println();
                    }
                    else {
                    	System.out.println("Trainer Not Found");
                    	System.out.println();
                    }
                    break;
                    
                case 3:
                	System.out.println("Enter TrainerId: ");
                    int trainerId1 = sc.nextInt();
                    trainerDAO.deleteTrainer(trainerId1);
                    System.out.println("Trainer Deleted Successfully");
                    System.out.println();
                    break;
                    
                case 4:
                	List<Trainer> trainers=trainerDAO.getAllTrainers();
                	for(Trainer trainer1:trainers) {
                		if (trainer1 != null) {
                            System.out.println("ID: " +trainer1.getTrainerId()+", Name: "+trainer1.getName());
                            System.out.println("Contact: " +trainer1.getContactNumber()+", Email: "+trainer1.getEmail());
                            System.out.println("Speciality: " +trainer1.getSpeciality());
                        } else {
                            System.out.println("Trainer not found.");
                        }
                		System.out.println();
                	}
                    break;
                    
                case 5:
                	System.out.println("Enter TrainerId: ");
                    int trainerId = sc.nextInt();
                    sc.nextLine(); 
                    Trainer trainer1 = trainerDAO.getTrainer(trainerId);
                    
                    if (trainer1 != null) {
                        System.out.println("ID: " +trainer1.getTrainerId()+", Name: "+trainer1.getName());
                        System.out.println("Contact: " +trainer1.getContactNumber()+", Email: "+trainer1.getEmail());
                        System.out.println("Speciality: " +trainer1.getSpeciality());
                    } else {
                        System.out.println("Trainer not found.");
                    }
            		System.out.println();
                	break;
                	
                case 6:
                	return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        }
		
		
	}
// This function deals with all functionalities of Member Management
	private static void manageMembers(Scanner sc,MemberDAO memberDAO) {
		while (true) {
			System.out.println("----- Member Management -----");
            System.out.println("1. Register Member");
            System.out.println("2. Update Member");
            System.out.println("3. Delete Member");
            System.out.println("4. View all Member Details");
            System.out.println("5. View Member Details based on memberId");
            System.out.println("6. Go Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	Member newMember = new Member();
                    System.out.println("Enter name: ");
                    newMember.setName(sc.nextLine());
                    System.out.println("Enter contact number: ");
                    newMember.setContactNumber(sc.nextLine());
                    System.out.println("Enter email: ");
                    newMember.setEmail(sc.nextLine());
                    System.out.println("Enter membership type: ");
                    newMember.setMembershipType(sc.nextLine());
                    memberDAO.addMember(newMember);
                    System.out.println("Member added Successfully");
                    System.out.println();
                    break;
                    
                case 2:
                	System.out.println("Enter member ID to update: ");
                    int memberIdToUpdate = sc.nextInt();
                    sc.nextLine(); 
                    
                    Member memberToUpdate = memberDAO.getMember(memberIdToUpdate);
                    if (memberToUpdate != null) {
                        System.out.println("Enter new name: ");
                        memberToUpdate.setName(sc.nextLine());
                        System.out.println("Enter new contact number: ");
                        memberToUpdate.setContactNumber(sc.nextLine());
                        System.out.println("Enter new email: ");
                        memberToUpdate.setEmail(sc.nextLine());
                        System.out.println("Enter new membership type: ");
                        memberToUpdate.setMembershipType(sc.nextLine());

                        memberDAO.updateMember(memberToUpdate);
                        System.out.println("Member updated successfully.");
                        System.out.println();
                    } else {
                        System.out.println("Member not found.");
                        System.out.println();
                    }
                    break;
                    
                case 3:
                	System.out.println("Enter MemberId: ");
                    int memberId1 = sc.nextInt();
                    sc.nextLine();
                    memberDAO.deleteMember(memberId1);
                    System.out.println("Member deleted successfully.");
                    System.out.println();
                    break;
                    
                case 4:
                	List<Member> members=memberDAO.getAllMembers();
                	System.out.println("All Member Details:");
                	for(Member member1:members) {
                		if (member1 != null) {
                            System.out.println("ID: " +member1.getMemberId()+", Name: " +member1.getName());
                            System.out.println("Contact: " +member1.getContactNumber()+", Email: " +member1.getEmail());
                            System.out.println("Membership Type: " +member1.getMembershipType());
                        } else {
                            System.out.println("Member not found.");
                        }
                		System.out.println();
                	}
                    break;
                    
                case 5:
                	System.out.println("Enter member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine(); 
                    
                    Member member1 = memberDAO.getMember(memberId);
                    if (member1 != null) {
                        System.out.println("ID: " +member1.getMemberId()+", Name: " +member1.getName());
                        System.out.println("Contact: " +member1.getContactNumber()+", Email: " +member1.getEmail());
                        System.out.println("Membership Type: " +member1.getMembershipType());
                    } else {
                        System.out.println("Member not found.");
                    }
            		System.out.println();
                	break;
                case 6:
                	return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
}