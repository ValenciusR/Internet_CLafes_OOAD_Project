package main;

import database.Connect;

public class Main {
	

	public Main() {
		Connect con = Connect.getInstance();
		
		con.insertUser("INSERT INTO USER VALUES(?,?,?,?,?)");
	}

	public static void main(String[] args) {
		new Main();
	}

}
