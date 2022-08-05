package com.candemirhan.recipeapp.server.client.communiication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.candemirhan.recipeapp.server.common.ApplicationLogger;
import com.candemirhan.recipeapp.server.common.CommonObject;
import com.candemirhan.recipeapp.server.dbo.Recipe;
import com.candemirhan.recipeapp.server.dbo.Role;
import com.candemirhan.recipeapp.server.dbo.User;


public class ClientHandler implements Runnable{

	private final Socket clientSocket;

	private PrintWriter    printWriter;
	private BufferedReader buffRead;
	
	public ClientHandler(Socket socket)
	{
		this.clientSocket = socket;
		this.printWriter = null;
		this.buffRead = null;
	}
	
	@Override
	public void run() {

		try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
			
			this.buffRead = in;
			this.printWriter = out;
			
			String line = null;
			
			while((line = this.buffRead.readLine()) != null)
			{
				this.processRequest(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void processRequest(String line) 
	{
		line = line.trim();
		ApplicationLogger.getInstance().logInfo("Received from Client " + line);
		
		String answer = null;
		
		if(line.toUpperCase().startsWith("INTR:"))
			answer = this.registerClient(line.substring(5));
		else if (line.toUpperCase().startsWith("LOGIN:")) 
			answer = this.checkLogin(line.substring(6));
		else if (line.toUpperCase().startsWith("RECIPES"))
			answer = this.listRecipes();
		
		this.printWriter.println(answer);
		this.printWriter.flush();
	}

	private String registerClient(String message) 
	{
		System.out.println("Mew client with UUID <<<" + message + ">>> registered");
		return "ACCEPTED";
	}

	private String checkLogin(String message) 
	{
		StringTokenizer tokenizer = new StringTokenizer(message, "|");
		User            user      = CommonObject.getInstance().checkUserCredentials(tokenizer.nextToken(), tokenizer.nextToken());
		if (user == null) {
			return "FAILURE|Wrong Login";
		}

		String         answer = "SUCCESS";
		Iterator<Role> iter   = user.getUserRoleSet().stream().map(s -> s.getRole()).collect(Collectors.toList()).iterator();
		while (iter.hasNext()) {
			String roleName = iter.next().getName();
			answer += "|" + roleName;
		}
		return answer;
	}

	private String listRecipes() 
	{
		List<Recipe> recipes = CommonObject.getInstance().getRecipes();
		if (recipes.isEmpty()) {
			return "FAILURE|No recipes found";
		}
		StringBuffer answer = new StringBuffer("SUCCESS");
		for (Recipe recipe : recipes) {
			if (recipe.isApproved()) {
				answer.append("|");
				answer.append(recipe.getName()).append("~");
				answer.append(recipe.getDescription()).append("~");
				answer.append(recipe.getServings()).append("~");
				answer.append(recipe.getCaloriesPerServing()).append("~");
				answer.append(recipe.getCaloriesPerServing()).append("~");
				answer.append(recipe.getRecipeType().getName());
			}
		}
		return answer.toString();
	}
}