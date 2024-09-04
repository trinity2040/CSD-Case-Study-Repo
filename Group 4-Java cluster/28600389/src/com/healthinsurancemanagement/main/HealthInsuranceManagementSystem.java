package com.healthinsurancemanagement.main;

import com.healthinsurancemanagement.dao.ClaimDAO;
import com.healthinsurancemanagement.dao.MemberDAO;
import com.healthinsurancemanagement.dao.PolicyDAO;
import com.healthinsurancemanagement.model.Claim;
import com.healthinsurancemanagement.model.Member;
import com.healthinsurancemanagement.model.Policy;

import java.sql.Date;
import java.util.Scanner;

public class HealthInsuranceManagementSystem  // This class serves as the entry point of the Health Insurance Management System
{
    private static Scanner scanner = new Scanner(System.in);
    private static MemberDAO memberDAO = new MemberDAO();
    private static PolicyDAO policyDAO = new PolicyDAO();
    private static ClaimDAO claimDAO = new ClaimDAO();

    public static void main(String[] args) 
    {
        displayMenu();
    }

    private static void displayMenu() 
    {
        while (true) //Infinite loop for continuous usage of the menu system till exit 
        {
            System.out.println("\n\n==== Health Insurance Management System ====");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Manage Members");
            System.out.println("2. Manage Policies");
            System.out.println("3. Manage Claims");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            
                case 1:
                    manageMembers();
                    break;
                case 2:
                    managePolicies();
                    break;
                case 3:
                    manageClaims();
                    break;
                case 4:
                    System.out.println("\nExiting... Thank you for using Health Insurance Management System !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private static void manageMembers() 
    {
        System.out.println("\n\n==== Manage Members ====");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Register New Member");
        System.out.println("2. View Member Details");
        System.out.println("3. Update Member Information");
        System.out.println("4. Delete Member");
        System.out.println("5. Back to Main Menu");
        System.out.print("\nEnter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
        {
            case 1:
                registerMember();  // For Fresh Registration of Members
                break;
            case 2:
                viewMemberDetails();  // For Viewing Member Details using Member ID
                break;
            case 3:
                updateMemberInformation();  // For updating any Member Information
                break;
            case 4:
                deleteMember();  // For Deleting any Existing Member
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void managePolicies() 
    {
        System.out.println("\n\n==== Manage Policies ====");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Add New Policy");
        System.out.println("2. View Policy Details");
        System.out.println("3. Update Policy Information");
        System.out.println("4. Delete Policy");
        System.out.println("5. Back to Main Menu");
        System.out.print("\nEnter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
        {
            case 1:
                addPolicy();    // For adding new policy to the system
                break;
            case 2:
                viewPolicyDetails();  // For viewing any existing policy
                break;
            case 3:
                updatePolicyInformation();  // For Updating the Policy Status 
                break;
            case 4:
                deletePolicy();       // For deleting any existing Policy
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageClaims() 
    {
        System.out.println("\n\n==== Manage Claims ====");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Submit New Claim");
        System.out.println("2. View Claim Details");
        System.out.println("3. Update Claim Information");
        System.out.println("4. Delete Claim");
        System.out.println("5. Back to Main Menu");
        System.out.print("\nEnter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) 
        {
            case 1:
                submitClaim();     // For submitting a new claim
                break;
            case 2:
                viewClaimDetails();    // For viewing any existing Claim
                break;
            case 3:
                updateClaimInformation();    // For updating any existing Claim Status/Info
                break;
            case 4:
                deleteClaim();    // For deleting any existing claim in the system
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void registerMember() 
    {
        System.out.print("\nEnter Member Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (YYYY-MM-DD) : ");
        Date dateOfBirth = Date.valueOf(scanner.nextLine());
        System.out.print("Enter Email : ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number : ");
        String phoneNumber = scanner.nextLine();

        Member member = new Member(0, name, dateOfBirth, email, phoneNumber);
        memberDAO.addMember(member);
        //System.out.println("\nMember registered successfully!");
    }

    private static void viewMemberDetails()
    {
        System.out.print("\nEnter Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        Member member = memberDAO.getMember(memberId);
        if (member != null) 
        {
            System.out.println(member);
        }
    }

    private static void updateMemberInformation() 
    {
        System.out.print("\nEnter Member ID to update: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        Member member = memberDAO.getMember(memberId);
        if (member != null) 
        {
            System.out.print("Enter New Name : ");
            member.setName(scanner.nextLine());
            System.out.print("Enter New Date of Birth (YYYY-MM-DD) : ");
            member.setDateOfBirth(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New Email : ");
            member.setEmail(scanner.nextLine());
            System.out.print("Enter New Phone Number : ");
            member.setPhoneNumber(scanner.nextLine());

            memberDAO.updateMember(member);
            //System.out.println("\nMember information updated successfully!");
        }
    }

    private static void deleteMember() 
    {
        System.out.print("\nEnter Member ID to delete : ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        memberDAO.deleteMember(memberId);
        //System.out.println("\nMember deleted successfully !");
    }

    private static void addPolicy() 
    {
        System.out.print("\nEnter Policy Number : ");
        String policyNumber = scanner.nextLine();
        System.out.print("Enter Policy Type : ");
        String type = scanner.nextLine();
        System.out.print("Enter Coverage Amount : ");
        double coverageAmount = scanner.nextDouble();
        System.out.print("Enter Premium Amount : ");
        double premiumAmount = scanner.nextDouble();
        scanner.nextLine(); 

        Policy policy = new Policy(0, policyNumber, type, coverageAmount, premiumAmount);
        policyDAO.addPolicy(policy);
        //System.out.println("\nPolicy added successfully!");
    }

    private static void viewPolicyDetails() 
    {
        System.out.print("Enter Policy ID: ");
        int policyId = scanner.nextInt();
        scanner.nextLine(); 

        Policy policy = policyDAO.getPolicy(policyId);
        if (policy != null) 
        {
            System.out.println(policy);
        } 
    }

    private static void updatePolicyInformation() 
    {
        System.out.print("\nEnter Policy ID to update : ");
        int policyId = scanner.nextInt();
        scanner.nextLine(); 

        Policy policy = policyDAO.getPolicy(policyId);
        if (policy != null) 
        {
            System.out.print("Enter New Policy Number : ");
            policy.setPolicyNumber(scanner.nextLine());
            System.out.print("Enter New Policy Type : ");
            policy.setType(scanner.nextLine());
            System.out.print("Enter New Coverage Amount : ");
            policy.setCoverageAmount(scanner.nextDouble());
            System.out.print("Enter New Premium Amount : ");
            policy.setPremiumAmount(scanner.nextDouble());
            scanner.nextLine(); 

            policyDAO.updatePolicy(policy);
            //System.out.println("\nPolicy information updated successfully!");
        } 
    }

    private static void deletePolicy() 
    {
        System.out.print("\nEnter Policy ID to delete: ");
        int policyId = scanner.nextInt();
        scanner.nextLine();

        policyDAO.deletePolicy(policyId);
        //System.out.println("\nPolicy deleted successfully!");
    }

    private static void submitClaim()
    {
        System.out.print("\nEnter Policy ID : ");
        int policyId = scanner.nextInt();
        System.out.print("Enter Member ID : ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Claim Date (YYYY-MM-DD) : ");
        Date claimDate = Date.valueOf(scanner.nextLine());
        System.out.print("Enter Claim Status (submitted/processed) : ");
        String status = scanner.nextLine();

        Claim claim = new Claim(0, policyId, memberId, claimDate, status);
        claimDAO.addClaim(claim);
        //System.out.println("\nClaim submitted successfully!");
    }

    private static void viewClaimDetails() 
    {
        System.out.print("\nEnter Claim ID : ");
        int claimId = scanner.nextInt();
        scanner.nextLine(); 

        Claim claim = claimDAO.getClaim(claimId);
        if (claim != null) 
        {
            System.out.println(claim);
            System.out.print(memberDAO.getMember(claim.getMemberId()));
            System.out.print(policyDAO.getPolicy(claim.getPolicyId()));
        } 
    }

    private static void updateClaimInformation() 
    {
        System.out.print("\nEnter Claim ID to update : ");
        int claimId = scanner.nextInt();
        scanner.nextLine();

        Claim claim = claimDAO.getClaim(claimId);
        if (claim != null) 
        {
            System.out.print("Enter New Policy ID : ");
            claim.setPolicyId(scanner.nextInt());
            System.out.print("Enter New Member ID : ");
            claim.setMemberId(scanner.nextInt());
            scanner.nextLine(); 
            System.out.print("Enter New Claim Date (YYYY-MM-DD) : ");
            claim.setClaimDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New Claim Status (submitted/processed) : ");
            claim.setStatus(scanner.nextLine());

            claimDAO.updateClaim(claim);
            //System.out.println("\nClaim information updated successfully!");
        } 
    }

    private static void deleteClaim() 
    {
        System.out.print("\nEnter Claim ID to delete : ");
        int claimId = scanner.nextInt();
        scanner.nextLine(); 

        claimDAO.deleteClaim(claimId);
        //System.out.println("Claim deleted successfully!");
    }
}
