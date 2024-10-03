package com.cts.sql.model;

import java.sql.Date;

public class MatchClass {
	int match_id;
	int team1_id;
	int team2_id;
	Date date;
	String venue;
	String result;
	
	public MatchClass() {}
	
	public MatchClass(int team1_id,int team2_id,Date date, String venue,String result) {
		//this.match_id = match_id;
		this.team1_id= team1_id;
		this.team2_id= team2_id;
		this.date = date;
		this.venue= venue;
		this.result=result;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getTeam1_id() {
		return team1_id;
	}
	public void setTeam1_id(int team1_id) {
		this.team1_id = team1_id;
	}
	public int getTeam2_id() {
		return team2_id;
	}
	public void setTeam2_id(int team2_id) {
		this.team2_id = team2_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
		
}
