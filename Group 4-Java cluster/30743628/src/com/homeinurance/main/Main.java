package com.homeinurance.main;
import java.time.LocalDate;
import java.util.Scanner;

import com.homeinsurance.dao.ClaimDAO;
import com.homeinsurance.dao.HomeownerDAO;
import com.homeinsurance.dao.policyDAO;
import com.homeinsurance.model.*;


public class Main {
	

	    private static policyDAO policyDAO = new policyDAO();
	    private static HomeownerDAO homeownerDAO = new HomeownerDAO();
	    private static ClaimDAO claimDAO = new ClaimDAO();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("Home Insurance Management System");
	            System.out.println("1. Manage Policies");
	            System.out.println("2. Manage Homeowners");
	            System.out.println("3. Manage Claims");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    managePolicies(scanner);
	                    break;
	                case 2:
	                    manageHomeowners(scanner);
	                    break;
	                case 3:
	                    manageClaims(scanner);
	                    break;
	                case 4:
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	  // MANAGE POLICY   
	    private static void managePolicies(Scanner scanner) {
	        System.out.println("1. Add Policy");
	        System.out.println("2. View Policy");
	        System.out.println("3. Update Policy");
	        System.out.println("4. Delete Policy");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                addPolicy(scanner);
	                break;
	            case 2:
	                viewPolicy(scanner);
	                break;
	            case 3:
	                updatePolicy(scanner);
	                break;
	            case 4:
	                deletePolicy(scanner);
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    }

	    private static void addPolicy(Scanner scanner) {      // ADD POLICY 
	        System.out.print("Enter policy number: ");
	        String policyNumber = scanner.next();
	        scanner.nextLine();
	        System.out.print("Enter policy type: ");
	        String type = scanner.nextLine();
	        System.out.print("Enter coverage amount: ");
	        double coverageAmount = scanner.nextDouble();
	        System.out.print("Enter premium amount: ");
	        double premiumAmount = scanner.nextDouble();

	        Policy policy = new Policy();
	        policy.setpolicyNumber(policyNumber);
	        policy.settype(type);
	        policy.setcoverageAmount(coverageAmount);
	        policy.setpremiumAmount(premiumAmount);

	        policyDAO.addPolicy(policy);
	        System.out.println("Policy added successfully.");
	    }

	    private static void viewPolicy(Scanner scanner) {   //VIEW POLICY 
	        System.out.print("Enter policy ID: ");
	        int policyId = scanner.nextInt();
	        Policy policy = policyDAO.getPolicyById(policyId);
	        if (policy != null) {
	            System.out.println("Policy Number: " + policy.getpolicyNumber());
	            System.out.println("Type: " + policy.gettype());
	            System.out.println("Coverage Amount: " + policy.getcoverageAmount());
	            System.out.println("Premium Amount: " + policy.getpremiumAmount());
	        } else {
	            System.out.println("Policy not found.");
	        }
	    }
	    private static void updatePolicy(Scanner scanner) {        // UPDATE POLICY 
	        System.out.print("Enter policy ID to update: ");
	        int policyId = scanner.nextInt(); 
	        Policy policy = policyDAO.getPolicyById(policyId);
	        if (policy != null) {
	            System.out.print("Enter new policy number: ");
	            String policyNumber = scanner.next();
	            System.out.print("Enter new policy type: ");
	            String type = scanner.next();
	            System.out.print("Enter new coverage amount: ");
	            double coverageAmount = scanner.nextDouble();
	            System.out.print("Enter new premium amount: ");
	            double premiumAmount = scanner.nextDouble();
	    
	            policy.setpolicyNumber(policyNumber);
	            policy.settype(type);
	            policy.setcoverageAmount(coverageAmount);
	            policy.setpremiumAmount(premiumAmount);
	    
	            policyDAO.updatePolicy(policy);
	        } else {
	            System.out.println("Policy not found.");
	        }
	    }
	    
	    private static void deletePolicy(Scanner scanner) {     //DELETE POLICY
	        System.out.print("Enter policy ID to delete: ");
	        int policyId = scanner.nextInt();
	        policyDAO.deletePolicy(policyId);
	    }

	// MANAGE HOMEOWNERS 

	    private static void manageHomeowners(Scanner scanner) {
	        System.out.println("1. Add Homeowner");
	        System.out.println("2. View Homeowner");
	        System.out.println("3. Update Homeowner");
	        System.out.println("4. Delete Homeowner");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                addHomeowner(scanner);
	                break;
	            case 2:
	                viewHomeowner(scanner);
	                break;
	            case 3:
	                updateHomeowner(scanner);
	                break;
	            case 4:
	                deleteHomeowner(scanner);
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    }

	    private static void addHomeowner(Scanner scanner) {  //REGISTER HOMEOWNER
	        System.out.println("Enter name: ");
	        String name = scanner.nextLine();
	        System.out.println("Enter email: ");
	        String email = scanner.nextLine();
	        scanner.nextLine();
	        System.out.println("Enter phone number: ");
	        String phoneNumber = scanner.nextLine();
	        System.out.println("Enter address: ");
	        String address = scanner.nextLine();
	    
	        Homeowner homeowner = new Homeowner();
	        homeowner.setName(name);
	        homeowner.setEmail(email);
	        homeowner.setPhoneNumber(phoneNumber);
	        homeowner.setAddress(address);
	    
	        homeownerDAO.addHomeowner(homeowner);
	    }
	    private static void viewHomeowner(Scanner scanner) {   // VIEW HOMEOWNER
	        System.out.print("Enter homeowner ID to view: ");
	        int homeownerId = scanner.nextInt();
	        Homeowner homeowner = homeownerDAO.getHomeownerById(homeownerId);
	        if (homeowner != null) {
	            System.out.println("Homeowner Details:");
	            System.out.println("ID: " + homeowner.getHomeownerId());
	            System.out.println("Name: " + homeowner.getName());
	            System.out.println("Email: " + homeowner.getEmail());
	            System.out.println("Phone Number: " + homeowner.getPhoneNumber());
	            System.out.println("Address: " + homeowner.getAddress());
	        } else {
	            System.out.println("Homeowner not found.");
	        }
	    }

	    private static void updateHomeowner(Scanner scanner) {  //UPDATE HoMEOWNER
	        System.out.print("Enter homeowner ID to update: ");
	        int homeownerId = scanner.nextInt();
	        Homeowner homeowner = homeownerDAO.getHomeownerById(homeownerId);
	        if (homeowner != null) {
	            System.out.println("Enter new name: ");
	            scanner.nextLine();  // Consume newline
	            String name = scanner.nextLine();
	            System.out.println("Enter new email: ");
	            String email = scanner.nextLine();
	            System.out.println("Enter new phone number: ");
	            String phoneNumber = scanner.nextLine();
	            System.out.println("Enter new address: ");
	            String address = scanner.nextLine();

	            homeowner.setName(name);
	            homeowner.setEmail(email);
	            homeowner.setPhoneNumber(phoneNumber);
	            homeowner.setAddress(address);

	            homeownerDAO.updateHomeowner(homeowner);
	        } else {
	            System.out.println("Homeowner not found.");
	        }
	    }

	    private static void deleteHomeowner(Scanner scanner) {  //DELETE HOMEOWNER
	        System.out.print("Enter homeowner ID to delete: ");
	        int homeownerId = scanner.nextInt();
	        homeownerDAO.deleteHomeowner(homeownerId);
	    }

	 // MANAGE CLAIMS   

	    private static void manageClaims(Scanner scanner) {
	        System.out.println("1. Submit Claim");
	        System.out.println("2. View Claim");
	        System.out.println("3. Update Claim");
	        System.out.println("4. Delete Claim");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        switch (choice) {
	            case 1:
	                submitClaim(scanner);
	                break;
	            case 2:
	                viewClaim(scanner);
	                break;
	            case 3:
	                updateClaim(scanner);
	                break;
	            case 4:
	                deleteClaim(scanner);
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    }
	    
	    
	    private static void submitClaim(Scanner scanner) { //SUBMIT CLAIM
	        System.out.print("Enter policy ID: ");
	        int policyId = scanner.nextInt();
	        System.out.print("Enter homeowner ID: ");
	        int homeownerId = scanner.nextInt();
	        System.out.print("Enter claim date (YYYY-MM-DD): ");
	        String claimDate = scanner.next();
	        System.out.print("Enter claim status (submitted/processed): ");
	        String status = scanner.next();

	        Claim claim = new Claim();
	        claim.setPolicyId(policyId);
	        claim.setHomeownerId(homeownerId);
	        claim.setStatus(status);
	        claim.setClaimDate(claimDate);

	        claimDAO.addClaim(claim);
	    }

	    private static void viewClaim(Scanner scanner) { //VIEW CLAIM
	        System.out.print("Enter claim ID to view: ");
	        int claimId = scanner.nextInt();
	        Claim claim = claimDAO.getClaimById(claimId);
	        if (claim != null) {
	            System.out.println("Claim Details:");
	            System.out.println("ID: " + claim.getClaimId());
	            System.out.println("Policy ID: " + claim.getPolicyId());
	            System.out.println("Homeowner ID: " + claim.getHomeownerId());
	            System.out.println("Claim Date: " + claim.getClaimDate());
	            System.out.println("Status: " + claim.getStatus());
	        } else {
	            System.out.println("Claim not found.");
	        }
	    }

	    private static void updateClaim(Scanner scanner) { //UPDATE CLAIM
	        System.out.print("Enter claim ID to update: ");
	        int claimId = scanner.nextInt();
	        Claim claim = claimDAO.getClaimById(claimId);
	        if (claim != null) {
	            System.out.print("Enter new policy ID: ");
	            int policyId = scanner.nextInt();
	            System.out.print("Enter new homeowner ID: ");
	            int homeownerId = scanner.nextInt();
	            System.out.print("Enter new claim date (YYYY-MM-DD): ");
	            String claimDate = scanner.next();
	            System.out.print("Enter new status (submitted/processed): ");
	            String status = scanner.next();

	            claim.setPolicyId(policyId);
	            claim.setHomeownerId(homeownerId);
	            claim.setClaimDate(claimDate);
	            claim.setStatus(status);

	            claimDAO.updateClaim(claim);
	        } else {
	            System.out.println("Claim not found.");
	        }
	    }

	    private static void deleteClaim(Scanner scanner) { //DELETE CLAIM
	        System.out.print("Enter claim ID to delete: ");
	        int claimId = scanner.nextInt();
	        claimDAO.deleteClaim(claimId);
	    }

	}


