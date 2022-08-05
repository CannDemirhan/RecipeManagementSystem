package com.candemirhan.recipeapp.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

import com.candemirhan.recipeapp.RecipeApprovedDatabaseListener;
import com.candemirhan.recipeapp.RecipeCreationDatabaseListener;
import com.candemirhan.recipeapp.client.common.CommonObject;
import com.candemirhan.recipeapp.client.communication.ServerCommunucation;
import com.candemirhan.recipeapp.client.view.Menu;

public class RecipeClient {
	
	private String id;
	private ServerCommunucation serverCommunucation;
	private Socket socket;
	private Scanner scanner;
	
	private Menu menu;
	
	public RecipeClient()
	{
		this.id = UUID.randomUUID().toString();
	}

	public static void main(String[] args)
	{
		RecipeClient recipeClient = new RecipeClient();
		recipeClient.conectToServer();
		recipeClient.connectToDatabase();
		recipeClient.startUserInterface();
	}
	
	private void startUserInterface()
	{
		
		
		boolean loginOK = false;
		
		while(!loginOK)
		{
			System.out.print("Please Enter Email Address: ");
			String email = menu.readString();
			System.out.println();

			System.out.print("Please Enter Password     : ");
			String password = menu.readString();
			System.out.println();
			
			loginOK = this.serverCommunucation.checkLogin(email,password);
			if(!loginOK)
				System.err.println("Username and Password are Wrong");			
		}
		int selection = 0;
		boolean exitMenu =false;
		
		while(!exitMenu)
		{
			selection = menu.readInteger();
			if(selection != 99)
				this.processSelection(selection);
		}
		
	}
	
	private void processSelection(int selection) 
	{
		switch(selection)
		{
			case 1:
				this.serverCommunucation.recipeList();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + selection);
		}
	}

	private void connectToDatabase() 
	{
		try {
			
			Class.forName("org.postgresql.Driver");
			String url = "jdbc::postgresql://localhost//RecipeDatabase";
			Connection conn = DriverManager.getConnection(url,"postgres","Turkoglu44*");
			(new Thread(new RecipeCreationDatabaseListener(conn))).start();
			(new Thread(new RecipeApprovedDatabaseListener(conn))).start();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void conectToServer() 
	{
		try {
			
			this.socket = new Socket(
					ClientProperties.getInstance().getServerAddress(),
					ClientProperties.getInstance().getServerPort()
					);
			this.serverCommunucation = new ServerCommunucation(this.socket);
			this.serverCommunucation.introduceClient(this.id);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Menu getMenuItems() 
	{
		if (this.menu == null) 
			this.initMenu();
		return this.menu;
	}

	private void initMenu() 
	{
		this.menu = new Menu
				.Builder()
				.title("Recipe App")
				.build();
		int i = 0;
		
		this.menu.addMenu(++i, "Recipe List");
		if(CommonObject.getInstance().hasSuperAdminRole())
			this.menu.addMenu(++i, "Introduce a New User");
		if(CommonObject.getInstance().hasAdminRole())
			this.menu.addMenu(++i, "Approve Recipe");
		this.menu.addMenu(++i, "Add a New Recipe");
		this.menu.addMenu(99, "Terminate the Program");
	}
}
