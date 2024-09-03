package com.cts.sql.model;
public class TeamClass{
    private int teamId;
    private String name;
    private String coach;
    private String captain;
    private int totalPlayers;

    public TeamClass() {}

    public TeamClass(String name, String coach, String captain) {
        this.name = name;
        this.coach = coach;
        this.captain = captain;
    }

    // Getters and Setters
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    @Override
    public String toString() {
        return "Team : [team_iD=" + this.teamId + ", Name=" + this.name + ", Coach=" + this.coach + ", Captain=" + this.captain + ", TotalPlayers=" + this.totalPlayers + "]";
    }
}
