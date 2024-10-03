package com.cts.sql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cts.sql.daointerface.TeamManagement;
import com.cts.sql.exceptions.PlayerNotFoundException;
import com.cts.sql.model.TeamClass;

public class TeamTable implements TeamManagement{

	public void addTeam(TeamClass teamclass) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "insert into team (name,coach,captain) values(?,?,?);";

        //TeamClass tclass = new TeamClass();
        PreparedStatement third = connection.prepareStatement(querys);
        third.setString(1, teamclass.getName());
        third.setString(2, teamclass.getCoach());
        third.setString(3,teamclass.getCaptain());
        //updateTotalPlayers(player.getTeamId());
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Team added succesfully..! ");
        }
        connection.close();
		
	}

	public TeamClass viewTeam(int id) throws PlayerNotFoundException ,Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "select * from team where team_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1,id);
        ResultSet res = third.executeQuery();
        TeamClass teamclass =null;
        while (res.next()) {
        	teamclass = new TeamClass();
//        	System.out.println("Team_id: "+res.getInt("team_id"));
//        	System.out.println("name : "+res.getString("name"));
//        	System.out.println("coach : "+res.getString("coach"));
//        	System.out.println("captain : "+res.getString("captain"));
//        	System.out.println("total_players : "+res.getInt("total_players"));
        	teamclass.setTeamId(res.getInt("team_id"));
        	teamclass.setName(res.getString("name"));
        	teamclass.setCoach(res.getString("coach"));
        	teamclass.setCaptain(res.getString("captain"));
        	teamclass.setTotalPlayers(res.getInt("total_players"));
        }
        
        return teamclass;
		
	}

	public void updateTeam(TeamClass teamclass) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "update team set name=? , coach=? ,captain=?  where team_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        //System.out.println(teamclass.getName());
        third.setString(1, teamclass.getName());
        third.setString(2, teamclass.getCoach());
        third.setString(3, teamclass.getCaptain());
        third.setInt(4, teamclass.getTeamId());
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Team updated succesfully..! ");
        }else {
        	System.out.println("Failed to update...");
        }
        connection.close();
	}

	public void delTeam(int del) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "delete from team where team_id=?;";
        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, del);
        int res = third.executeUpdate();
        if (res>0) {
        	System.out.println("Team deleted succesfully..! ");
        }
	}

	public void viewAllTeam() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13") ;
	        String query = "select * from team;";

	        PreparedStatement stmt = connection.prepareStatement(query);
	        ResultSet res = stmt.executeQuery();

	            while (res.next()) {

	            	System.out.printf("%-10s %-20s %-20s %-20s %-15s\n", "Team ID", "Name", "Coach", "Captain", "Total Players");
	            	System.out.println("--------------------------------------------------------------------------------");
	            	System.out.printf("%-10d %-20s %-20s %-20s %-15d\n",res.getInt("team_id"),res.getString("name"),res.getString("coach"),res.getString("captain"),res.getInt("total_players"));

	                
//	                System.out.printf("%-10s %-20s %-20s %-20s %-15s\n", "Team ID", "Coach", "Captain", "Total Players");
//					System.out.println("--------------------------------------------------------------------------------");
//				    System.out.printf("%-10d %-20s %-20s %-20s %-15d\n",res.getInt("team_id"),res.getString("name"),res.getString("coach"),res.getString("captain"),res.getInt("total_players"));
	            }
	            
		
	}
	
	
}
