package com.candemirhan.recipeapp.client.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import com.candemirhan.recipeapp.client.common.CommonObject;

public class ServerCommunucation {

	private PrintWriter printWriter;
	private BufferedReader buffRead;
	
	public ServerCommunucation(Socket socket)
	{
		try {
			this.printWriter = new PrintWriter(socket.getOutputStream(),true);
			this.buffRead  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void introduceClient(String id) throws IOException
	{
		boolean waitForServer = true;
		
		while(waitForServer)
		{
			waitForServer = this.introduce(id);
			System.out.println("Server is in Wait");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean introduce(String id) throws IOException 
	{
		this.printWriter.println("INTR" + id);
		this.printWriter.flush();
		
		String serverResponse = this.buffRead.readLine();
		
		if(serverResponse.startsWith("WAIT"))
			return true;
		else
			return false;
	}

	public boolean checkLogin(String email, String password) 
	{
		printWriter.println("LOGIN" + email + "|" + password);
		printWriter.flush();
		String answer = null;
		try {
			
			answer = buffRead.readLine();
			StringTokenizer token = new StringTokenizer("|");
			while(token.hasMoreTokens())
				CommonObject.getInstance().addRole(token.nextToken());
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Communication failure due <<<" + e.getMessage() + ">>>");
		}
		return false;
	}
	public void recipeList() {
		printWriter.println("RECIPES");
		String answer = null;
		try {
			answer = buffRead.readLine();
			if (answer.startsWith("FAILURE")) {
				System.out.println("Sistemde herhangi bir yemek tarifi bulunamadı");
			}
			answer = answer.substring(8);
			System.out.println(answer);
		}
		catch (IOException e) {
			System.err.println("Communication failure due <<<" + e.getMessage() + ">>>");
		}
	}
}
