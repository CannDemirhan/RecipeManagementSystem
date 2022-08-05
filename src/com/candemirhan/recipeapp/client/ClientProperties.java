package com.candemirhan.recipeapp.client;

import com.candemirhan.recipeapp.utils.PropUtility;

public class ClientProperties {
	
	private static ClientProperties instance;
	private PropUtility propUtility;
	
	private ClientProperties() 
	{
		this.propUtility = PropUtility.getInstance();
		propUtility.setClientPropertiesFilePath("C:\\Users\\Asus\\eclipse-workspace\\RecipeDB\\resources", "client.properties");
	}
	
	public static ClientProperties getInstance()
	{
		if(ClientProperties.instance == null)
			ClientProperties.instance = new ClientProperties();
		return ClientProperties.instance;
	}
	
	public String getServerAddress()
	{
		return propUtility.getClientProperty("SERVER_ADDR");
	}
	public int getServerPort()
	{
		return Integer.parseInt(propUtility.getClientProperty("SERVER_PORT"));
	}
	public String getDefaultLanguage()
	{
		return propUtility.getClientProperty("DEFAULT_LANG");
	}
}
