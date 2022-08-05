package com.candemirhan.recipeapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

public class RecipeApprovedDatabaseListener implements Runnable{
	
	private Connection   conn;
	private PGConnection pgConn;
	
	public RecipeApprovedDatabaseListener(Connection conn) throws SQLException {
		super();
		this.conn = conn;
		this.pgConn = (PGConnection)conn;
		Statement stmt = conn.createStatement();
		stmt.execute("LISTEN recipe_approved");
		stmt.close();
	}
	
	public void run() {
		try {
			while (true) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 1"); 
				rs.close();
				stmt.close();
				
				PGNotification[] notifications = pgConn.getNotifications();
				if (notifications != null) {
					for (PGNotification notification : notifications) {
						System.out.println("New Recipe is Approved " + notification.getParameter());
					}
				}
				else {
					System.out.println("No news good news");
				}
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}