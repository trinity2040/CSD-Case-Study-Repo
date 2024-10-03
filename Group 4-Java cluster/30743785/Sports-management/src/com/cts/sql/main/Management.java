package com.cts.sql.main;

import java.util.*;

import com.cts.sql.dao.MatchTable;
import com.cts.sql.dao.PlayerTable;
import com.cts.sql.dao.TeamTable;
import com.cts.sql.daointerface.MatchManagement;
import com.cts.sql.daointerface.PlayerManagement;
import com.cts.sql.daointerface.TeamManagement;
import com.cts.sql.exceptions.MatchNotFoundException;
import com.cts.sql.exceptions.PlayerNotFoundException;
import com.cts.sql.exceptions.TeamNotFoundException;
import com.cts.sql.model.MatchClass;
import com.cts.sql.model.PlayerClass;
import com.cts.sql.model.TeamClass;


import java.sql.Date;

public class Management {
	Scanner sc = new Scanner(System.in);
	
	
	public void fetchDataTeam() {
		
		System.out.println("Welcome to the Team Table..:");
		System.out.println("1. Add new Team :");
		System.out.println("2. View the Team by id :");
		System.out.println("3. Update the Team :");
		System.out.println("4. Delete the Team ;");
		System.out.println("5. View all Team :");
		
		System.out.println("Enter your operation in num :");
		int choice = sc.nextInt();
	//	TeamManagement teamManager = new TeamManagementImpl();
		TeamManagement teamManager = new TeamTable();
		try {
		switch(choice) {
		case 1:
			System.out.println("Enter the team name :");
			String tname = sc.next();
			System.out.println("Enter the team coach :");
			String tcoach = sc.next();
			System.out.println("Enter the team captain :");
			String tcaptain = sc.next();
			TeamClass teamclass = new TeamClass(tname,tcoach,tcaptain);
			teamManager.addTeam(teamclass);
			break;
		case 2:
			System.out.println("Enter the team id to view :");
			int id = sc.nextInt();
			TeamClass teamclas = teamManager.viewTeam(id);
			if(teamclas!=null) {
				System.out.printf("%-10s %-20s %-20s %-20s %-15s\n", "Team ID", "Name", "Coach", "Captain", "Total Players");
            	System.out.println("--------------------------------------------------------------------------------");
            	System.out.printf("%-10d %-20s %-20s %-20s %-15d\n",teamclas.getTeamId(),teamclas.getName(),teamclas.getCoach(),teamclas.getCaptain(),teamclas.getTotalPlayers());
			}
			else {
				throw new TeamNotFoundException("Team with ID " + id + " does not exist.") ;
			}
			break;
		case 3:
			System.out.println("Enter the team id to update :");
			int uid = sc.nextInt();
			TeamClass uteamclass = teamManager.viewTeam(uid);
			
			if(uteamclass != null) {
			System.out.println("Enter the team name :");
			uteamclass.setName(sc.next());
			System.out.println("Enter the team coach :");
			uteamclass.setCoach(sc.next());
			System.out.println("Enter the team captain :");
			uteamclass.setCaptain(sc.next());
			teamManager.updateTeam(uteamclass);
			}
			
			if(uteamclass==null) {
				throw new TeamNotFoundException("Team with ID " + uid + " does not exist.") ;
			}
			break;
		case 4:
			System.out.println("Enter the team id to delete :");
			int del = sc.nextInt();
			teamManager.delTeam(del);
			break;
		case 5:
			teamManager.viewAllTeam();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			break;
		}
		}catch(Exception e) {
			System.out.println("Error :"+ e.getMessage());
		}
		
	}

	public void fetchDataPlayer() {
		System.out.println("Welcome to the Player Table..:");
		System.out.println("1. Add new Player :");
		System.out.println("2. View the Player by player_id :");
		System.out.println("3. Update the Player :");
		System.out.println("4. Delete the Player :");
		System.out.println("5. View all Player :");
		
		System.out.println("Enter your operation in num :");
		int choice = sc.nextInt();
		PlayerManagement playManager = new PlayerTable();
		//PlayerTable player = new PlayerTable();
		try {
		switch(choice) {
		case 1:
			System.out.println("Enter the player name :");
			String pname = sc.next();
			System.out.println("Enter the player age :");
			int age= sc.nextInt();
			System.out.println("Enter the player team_id :");
			int tid= sc.nextInt();
			System.out.println("Enter the position :");
			String pos = sc.next();
			PlayerClass playerclass = new PlayerClass(pname,age,tid,pos);
			
			playManager.addPlayer(playerclass); 
			break;
		case 2:
			System.out.println("Enter the player_id to view :");
			int pid = sc.nextInt();
			
			PlayerClass playclas = playManager.viewPlayer(pid);
			if(playclas!=null) {
				System.out.printf("%-10s %-20s %-10s %-10s %-15s%\n", "Player ID", "Name", "Age", "Team ID", "Position");
				System.out.println("----------------------------------------------------------------------------------");
			    System.out.printf("%-10d %-20s %-10d %-10d %-15s%\n",playclas.getPlayer_id(),playclas.getName(),playclas.getAge(),playclas.getTeamid(),playclas.getPosition());
			}else {
				throw new PlayerNotFoundException("Player with ID " + pid + " does not exist.");
			}
			//System.out.println(player.viewPlayer(pid)); 
			return;
		case 3:
			System.out.println("Enter the player_id to update :");
			int uid = sc.nextInt(); 
			PlayerClass uplayclas = playManager.viewPlayer(uid);
			if(uplayclas!=null) {
				System.out.println("Enter the player name to update:");
				
				uplayclas.setName(sc.next());
				System.out.println("Enter the player age to update:");
				//int uage = sc.nextInt();
				uplayclas.setAge(sc.nextInt());
				System.out.println("Enter the player team_id to update:");
				//int utid= ;
				uplayclas.setTeamid(sc.nextInt());
				System.out.println("Enter the position to update:");
				uplayclas.setPosition(sc.next());
				playManager.updatePlayer(uplayclas);
			}else {
				throw new PlayerNotFoundException("Player with ID " + uid + " does not exist.");
			}
			
			break;
		case 4:
			System.out.println("Enter the player_id to delete :");
			int del = sc.nextInt();
			playManager.delPlayer(del);
			break;
		case 5:
			playManager.viewAllPlayer();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			return;
		}
		}catch(Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
		
	}

	public void fetchDataMatch() throws Exception {
		System.out.println("Welcome to the Match Table..:");
		System.out.println("1. Schedule a new Match :");
		System.out.println("2. View the Match using Match_id :");
		System.out.println("3. Update the Match :");
		System.out.println("4. Delete the Player :");
		System.out.println("5. Record the Match result :");
		System.out.println("6. View all the match");
		
		System.out.println("Enter your operation in num :");
		int choice = sc.nextInt();
		MatchManagement matchManager= new MatchTable();
		try {
		switch(choice) {
		case 1:
			System.out.println("Enter the team 1 id :");
			int t1= sc.nextInt();
			System.out.println("Enter the team 2 id :");
			int t2= sc.nextInt();
			System.out.println("Enter the match date(yyyy-mm-dd) :");
			String dte = sc.next();
			Date date = Date.valueOf(dte);
			
			System.out.println("Enter the Venue:");
			String venue = sc.next();
			System.out.println("Enter the result:");
			String result = sc.next();
			
			//MatchClass matchclass = new MatchClass(t1,t2,date,venue,result);
			matchManager.addMatch(new MatchClass(t1,t2,date,venue,result));
			break;
		case 2:
			System.out.println("Enter the match_id to view :");
			int id = sc.nextInt();
			MatchClass matchcl = matchManager.viewMatch(id);
			if(matchcl!=null) {
				System.out.println();
				System.out.printf("%-10s%-10s%-10s%-10s%-15s%-10s%n","Match ID", "Team 1 ID", "Team 2 ID", "Date", "Venue", "Result");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.printf("%-10s%-10s%-10s%-10s%-15s%-10s%n", matchcl.getMatch_id(), matchcl.getTeam1_id(), matchcl.getTeam2_id(), matchcl.getDate(),matchcl.getVenue(),  matchcl.getResult());
			}else {
				throw new MatchNotFoundException("Match with ID " + id + " does not exist.");
			}
			break;
		case 3:
			System.out.println("Enter the match_id to update:");
			int matchid = sc.nextInt();
			
			MatchClass matchcla = matchManager.viewMatch(matchid);
			if(matchcla!=null) {
			System.out.println("Enter the team 1 id to update:");
			//int ut1= sc.nextInt();
			matchcla.setTeam1_id(sc.nextInt());
			System.out.println("Enter the team 2 id to update:");
			//int ut2= sc.nextInt();
			matchcla.setTeam2_id(sc.nextInt());
			System.out.println("Enter the match date(yyyy/mm/dd)to update :");
			String ud = sc.next();
			Date udate = Date.valueOf(ud);
			matchcla.setDate(udate);
			sc.nextLine();
			System.out.println("Enter the Venue to update:");
			matchcla.setVenue(sc.next());
			System.out.println("Enter the result to update:");
			//String uresult = sc.next();
			matchcla.setResult(sc.next());
			matchManager.updateMatch(matchcla);
			}else {
				throw new MatchNotFoundException("Match_id You Entered "+matchid+" does not found!");
			}
			break;
		case 4:
			System.out.println("Enter the match_id to delete :");
			int del = sc.nextInt();
			matchManager.delMatch(del);
			break;
		case 5:
			System.out.println("Enter the Match id to update and record the results :");
			int matc = sc.nextInt();
			System.out.println("Enter the Result to record :");
			String re = sc.next();
			matchManager.updateMatchRecord(matc,re);
			break;
		case 6:
			matchManager.viewAllMatch();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			return;
			
		}
		}catch(Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
		
	}
		
}
