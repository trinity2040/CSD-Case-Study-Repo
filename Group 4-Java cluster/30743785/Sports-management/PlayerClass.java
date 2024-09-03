package cts.sql.sp;

public class PlayerClass {
	int player_id;
	String name;
	int age;
	int teamid;
	String position;
	public PlayerClass(String pname, int age2, int tid, String pos) {
		this.age=age2;
		this.name=pname;
		this.position=pos;
		this.teamid=tid;
	}
	public PlayerClass() {}
	
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String toString() {
		return "Player : { Player_id : "+this.player_id+",name : "+this.name+",age : "+this.age+",team_id : "+this.teamid+",position : "+this.position+ "}";
	}
}
