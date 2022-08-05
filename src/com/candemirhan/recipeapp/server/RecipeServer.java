package com.candemirhan.recipeapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.candemirhan.recipeapp.server.client.communiication.ClientHandler;
import com.candemirhan.recipeapp.server.common.ApplicationLogger;

public class RecipeServer {
	
	private static RecipeServer instance;
	
	private RecipeServer() {super();}
	
	public static RecipeServer getInstance()
	{
		if(RecipeServer.instance == null)
			RecipeServer.instance = new RecipeServer();
		return RecipeServer.instance;
	}
	
	public static void main(String[] args) 
	{	
		(RecipeServer.getInstance()).startServer();
	}

	private void startServer() 
	{
		try(ServerSocket serSocket = new ServerSocket(ServerProperties.getInstance().getServerPort())){
			
			serSocket.setReuseAddress(true);
			ApplicationLogger.getInstance()
								.logInfo("Server Started and Waiting for Clients..");
			
			while(true)
			{
				Socket socket = serSocket.accept();
				ApplicationLogger.getInstance()
								.logInfo("New Client Connected " +
											socket.getInetAddress().getHostAddress()
											);
				(new Thread(new ClientHandler(socket))).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
