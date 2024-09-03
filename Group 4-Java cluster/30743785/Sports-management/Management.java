package cts.sql.sp;

import java.util.*;
import java.sql.Date;

public class Management {
	Scanner sc = new Scanner(System.in);
	public void fetchDataTeam() throws Exception {
		
		System.out.println("Welcome to the Team Table..:");
		System.out.println("1. Add new Team :");
		System.out.println("2. View the Team :");
		System.out.println("3. Update the Team :");
		System.out.println("4. Delete the Team ;");
		System.out.println("5. View all Team :");
		
		System.out.println("Enter your operation in num :");
		int choice = sc.nextInt();
		TeamTable team = new TeamTable();
		
		switch(choice) {
		case 1:
			System.out.println("Enter the team name :");
			String tname = sc.next();
			System.out.println("Enter the team coach :");
			String tcoach = sc.next();
			System.out.println("Enter the team captain :");
			String tcaptain = sc.next();
			TeamClass teamclass = new TeamClass(tname,tcoach,tcaptain);
			team.addTeam(teamclass);
			break;
		case 2:
			System.out.println("Enter the team id to view :");
			int id = sc.nextInt();
			System.out.println(team.viewTeam(id)); 
			break;
		case 3:
			System.out.println("Enter the team id to update :");
			int uid = sc.nextInt();
			TeamClass uteamclass = team.viewTeam(uid);
			
			if(uteamclass != null) {
			System.out.println("Enter the team name :");
			uteamclass.setName(sc.next());
			System.out.println("Enter the team coach :");
			uteamclass.setCoach(sc.next());
			System.out.println("Enter the team captain :");
			uteamclass.setCaptain(sc.next());
			team.updateTeam(uteamclass);
			}else {
				System.out.println("Team not Found");
			}
			break;
		case 4:
			System.out.println("Enter the team id to delete :");
			int del = sc.nextInt();
			team.delTeam(del);
			break;
		case 5:
			team.viewAllTeam();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			break;
		}
		
	}

	public void fetchDataPlayer() throws Exception {
		System.out.println("Welcome to the Player Table..:");
		System.out.println("1. Add new Player :");
		System.out.println("2. View the Player bu player_id :");
		System.out.println("3. Update the Player :");
		System.out.println("4. Delete the Player :");
		System.out.println("5. View all Player :");
		
		System.out.println("Enter your operation in num :");
		int choice = sc.nextInt();
		PlayerTable player = new PlayerTable();
		
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
			
			player.addPlayer(playerclass); 
			break;
		case 2:
			System.out.println("Enter the player_id to view :");
			int pid = sc.nextInt();
			System.out.println(player.viewPlayer(pid)); 
			break;
		case 3:
			System.out.println("Enter the player name to update:");
			String uname = sc.next();
			System.out.println("Enter the player age to update:");
			int uage = sc.nextInt();
			System.out.println("Enter the player team_id to update:");
			int utid= sc.nextInt();
			System.out.println("Enter the position to update:");
			String upos = sc.next();
			System.out.println("Enter the player_id to update :");
			int uid = sc.nextInt(); 
			
			player.updatePlayer(uname,uage,utid,uid,upos);
			break;
		case 4:
			System.out.println("Enter the player_id to delete :");
			int del = sc.nextInt();
			player.delPlayer(del);
			break;
		case 5:
			player.viewAllPlayer();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			break;
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
		MatchTable match = new MatchTable();
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
			
			MatchClass matchclass = new MatchClass(t1,t2,date,venue,result);
			match.addMatch(matchclass);
			break;
		case 2:
			System.out.println("Enter the match_id to view :");
			int id = sc.nextInt();
			System.out.println(match.viewMatch(id)); 
			break;
		case 3:
			System.out.println("Enter the team 1 id to update:");
			int ut1= sc.nextInt();
			System.out.println("Enter the team 2 id to update:");
			int ut2= sc.nextInt();
			System.out.println("Enter the match date(yyyy/mm/dd)to update :");
			String ud = sc.next();
			Date udate = Date.valueOf(ud);
			sc.nextLine();
			System.out.println("Enter the Venue to update:");
			String uvenue = sc.next();
			System.out.println("Enter the result to update:");
			String uresult = sc.next();
			System.out.println("Enter the match_id to update:");
			int matchid = sc.nextInt();
			match.updateMatch(ut1,ut2,udate,uvenue,uresult,matchid);
			break;
		case 4:
			System.out.println("Enter the match_id to delete :");
			int del = sc.nextInt();
			match.delMatch(del);
			break;
		case 5:
			System.out.println("Enter the Match id to update and record the results :");
			int matc = sc.nextInt();
			System.out.println("Enter the Result to record :");
			String re = sc.next();
			match.updateMatchRecord(matc,re);
			break;
		case 6:
			match.viewAllMatch();
			break;
		default:
			System.out.println("Enter the correct Choice...");
			break;
		}
		
	}
}
