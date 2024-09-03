package cts.sql.sp;
import java.sql.*;
public class MatchTable {

	public void addMatch(MatchClass matchclass)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "insert into matchtable(team1_id,team2_id,match_date,venue,result) values(?,?,?,?,?);";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, matchclass.getTeam1_id());
        third.setInt(2, matchclass.getTeam2_id());
        third.setDate(3,matchclass.getDate());
        third.setString(4,matchclass.getVenue());
        third.setString(5,matchclass.getResult());
        
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Match added succesfully..! ");
        }
        connection.close();
	}

	public MatchClass viewMatch(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "select * from matchtable where match_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, id);
        ResultSet res = third.executeQuery();
        MatchClass matchclass = null;
        while (res.next()) {
//        	System.out.println("Match_id :"+res.getInt("match_id"));
//        	System.out.println("Team1_id: "+res.getInt("team1_id"));
//        	System.out.println("Team2_id : "+res.getInt("team2_id"));
//        	System.out.println("Match Date : "+res.getDate("match_date"));
//        	System.out.println("Venue : "+res.getString("venue"));
//        	System.out.println("Result : "+res.getString("result"));
        	
        	matchclass = new MatchClass();
        	matchclass.setMatch_id(res.getInt("match_id"));
        	matchclass.setTeam1_id(res.getInt("team1_id"));
        	matchclass.setTeam2_id(res.getInt("team2_id"));
        	matchclass.setDate(res.getDate("match_date"));
        	matchclass.setVenue(res.getString("venue"));
        	matchclass.setResult(res.getString("result"));
        }
        
//        if(res.next()==false) {
//        	System.out.println("Match_id not found...");
//        }
        connection.close();
        return matchclass;
        
		
	}

	

	public void delMatch(int del) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "delete from matchtable where match_id=?;";
        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, del);
        int res = third.executeUpdate();
        if (res>0) {
        	System.out.println("Match deleted succesfully..! ");
        }
	}

	public void updateMatch(int ut1, int ut2, Date udate, String uvenue, String uresult, int matchid) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "update matchtable set team1_id=?,team2_id=?,match_date=?,venue=?,result=? where match_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        third.setInt(1, ut1);
        third.setInt(2, ut2);
        third.setDate(3,udate);
        third.setString(4,uvenue);
        third.setString(5,uresult);
        third.setInt(6, matchid);
        
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Match updated succesfully..! ");
        }
        connection.close();
	}

	public void updateMatchRecord(int matc, String re) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");

        String querys = "update matchtable set result=? where match_id=?;";


        PreparedStatement third = connection.prepareStatement(querys);
        
        third.setString(1,re);
        third.setInt(2, matc);
        
        int res = third.executeUpdate();

        if (res>0) {
        	System.out.println("Match updated succesfully..! ");
        }
        connection.close();
	}

	public void viewAllMatch() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_tournament", "root", "Moha12Villan13");
	        String query = "select * from matchtable;";
	        try {
	        	PreparedStatement stmt = connection.prepareStatement(query);
		        ResultSet res = stmt.executeQuery();

		            while (res.next()) {
		            	System.out.println("Match_id :"+res.getInt("match_id"));
		            	System.out.println("Team1_id: "+res.getInt("team1_id"));
		            	System.out.println("Team2_id : "+res.getInt("team2_id"));
		            	System.out.println("Match Date : "+res.getDate("match_date"));
		            	System.out.println("Venue : "+res.getString("venue"));
		            	System.out.println("Result : "+res.getString("result"));
		            	System.out.println();
		            }
		            if(res.next()==false) {
		            	System.out.println("match_id not found...");
		            }
	        }catch(Exception e) {
	        	System.out.println("Exception :"+e);
	        }
	        
		
	}

}
