package com.candemirhan.recipeapp.server;

import com.candemirhan.recipeapp.utils.PropUtility;

public class ServerProperties {
	
	private static ServerProperties instance;
	private PropUtility propUtility;
	
	private ServerProperties()
	{
		this.propUtility = PropUtility.getInstance();
		propUtility.setServerPropertiesFilePath("C:\\Users\\Asus\\eclipse-workspace\\RecipeDB\\resources", "server.properties");
	}
	
	public static ServerProperties getInstance()
	{
		if(ServerProperties.instance == null)
			ServerProperties.instance = new ServerProperties();
		return ServerProperties.instance;
	}

	public int getServerPort()
	{
		return Integer.parseInt(this.propUtility.getServerProperty("SERVER_PORT"));
	}
}
