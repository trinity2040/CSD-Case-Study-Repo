package com.cts.sql.main;
import java.util.*;

public class SportsManage {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String ch = "";
		do {
			System.out.println("Welcome to Sports Managemnet");
			System.out.println("1. Team Table");
			System.out.println("2. Player Table");
			System.out.println("3. Match Table");
			System.out.println("Enter your num to open the table: ");
			int num = sc.nextInt();
			Management manage = new Management();
			switch(num) {
			case 1:
				manage.fetchDataTeam();
				break;
			case 2 :
				manage.fetchDataPlayer();
				break;
			case 3:
				manage.fetchDataMatch();
				break;
			default:
				System.out.println("Enter the Correct Details...!");
				break;
			}
			System.out.println("do You Wish to Continue(y) :");
			ch=sc.next();
		}while(ch.equalsIgnoreCase("y"));
		
	}
}
