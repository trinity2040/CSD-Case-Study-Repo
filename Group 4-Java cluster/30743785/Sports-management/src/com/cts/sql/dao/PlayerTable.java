package com.cts.sql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cts.sql.model.PlayerClass;

public class PlayerTable {

	public void addPlayer(PlayerClass playerclass) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "insert into player (name,age,team_id,position) values(?,?,?,?);";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setString(1, playerclass.getName());
        third.setInt(2, playerclass.getAge());
        third.setInt(3,playerclass.getTeamid());
        third.setString(4,playerclass.getPosition());
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Player added succesfully..! ");
        	
        	
        	String qus = "update team set total_players= (select count(*) from player where team_id=?) where team_id=?;";
            
            PreparedStatement thi = connection.prepareStatement(qus);
            thi.setInt(1, playerclass.getTeamid());
            thi.setInt(2, playerclass.getTeamid());
            int r = thi.executeUpdate();
            if(r>0) {
            	System.out.println("Total players updated succesfully..! ");
            }
        }
        connection.close();
		
	}

	public PlayerClass viewPlayer(int pid) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "select * from player where player_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, pid);
        ResultSet res = third.executeQuery();
        PlayerClass playerclass = null;
        while (res.next()) {
        	
//        	System.out.println("Player_id: "+res.getInt("player_id"));
//        	System.out.println("name : "+res.getString("name"));
//        	System.out.println("age : "+res.getInt("age"));
//        	System.out.println("team_id : "+res.getInt("team_id"));
//        	System.out.println("position : "+res.getString("position"));
        	
        	playerclass =  new PlayerClass();
        	
        	playerclass.setName(res.getString("name"));
        	playerclass.setPlayer_id(res.getInt("player_id"));
        	playerclass.setAge(res.getInt("age"));
        	playerclass.setTeamid(res.getInt("team_id"));
        	playerclass.setPosition(res.getString("position"));
        	
        }
        connection.close();
        return playerclass;
        
        
	}

	public void delPlayer(int del) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");
        
        String qu = "select team_id from player where player_id=?;";
        PreparedStatement thi = connection.prepareStatement(qu);
        
        thi.setInt(1, del);
        
        ResultSet r = thi.executeQuery();
        
        
        
        while(r.next()) {
        	int teamid = r.getInt("team_id");
            //System.out.println(teamid);
            String querys = "delete from player where player_id=?;";
            PreparedStatement third = connection.prepareStatement(querys);
            third.setInt(1, del);
            int res = third.executeUpdate();
        
        
            if (res>0) {
            	System.out.println("Product deleted succesfully..! ");
        	
            	String qus = "update team set total_players= (select count(*) from player where team_id=?) where team_id=?;";
            
            	PreparedStatement th = connection.prepareStatement(qus);
            	th.setInt(1, teamid);
            	th.setInt(2, teamid);
            	int ro = th.executeUpdate();
            		if(ro>0) {
            			System.out.println("Total players updated succesfully..! ");
            		}
        	}else {
                System.out.println("Player_id not found...!");  
            }
        }
  }
        

	public void updatePlayer(String uname, int uage, int utid, int uid, String upos) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "update player set name=? , age=? ,team_id=?,position=? where player_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setString(1, uname);
        third.setInt(2, uage);
        third.setInt(3,utid);
        third.setString(4, upos);
        third.setInt(5, uid);
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Product updated succesfully..! ");
        	
        	String qus = "update team set total_players= (select count(*) from player where team_id=?) where team_id=?;";
            
            PreparedStatement thi = connection.prepareStatement(qus);
            thi.setInt(1, utid);
            thi.setInt(2, utid);
            int r = thi.executeUpdate();
            if(r>0) {
            	System.out.println("Total players updated succesfully..! ");
            }
        }else {
        	System.out.println("Product_id no found ...");
        }
        connection.close();
	}

	public  void viewAllPlayer() throws Exception {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");
	        String query = "select * from player;";

	        PreparedStatement stmt = connection.prepareStatement(query);
	        ResultSet res = stmt.executeQuery();
	        Boolean check = false;
	            while (res.next()) {

	                System.out.println("Player_id: " + res.getInt("player_id"));
	                System.out.println("Name: " + res.getString("name"));
	                System.out.println("Age: " + res.getInt("age"));
	                System.out.println("Team_id: " + res.getInt("team_id"));
	                System.out.println("Position: " + res.getString("position"));
	                System.out.println("");
	                check=true;
	            }
	            if(res.next()==false && check==false) {
	            	System.out.println("Player_id not found...");
	            }
	    
	}
}
