package com.candemirhan.recipeapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class PropUtility {
	
	private static PropUtility instance;
	
	private Properties clientProperties;
	private String clientPropertiesFilePath;
	
	private Properties serverProperties;
	private String serverPropertiesFilePath;
	
	private PropUtility() {super();}
	
	public static PropUtility getInstance()
	{
		if(PropUtility.instance == null)
			PropUtility.instance = new PropUtility();
		return PropUtility.instance;
	}
	
	public void setServerPropertiesFilePath(String filePath, String fileName)
	{
		this.serverPropertiesFilePath = filePath.replaceAll("%20", " ") + "\\" + fileName;
	}
	public void setClientPropertiesFilePath(String filePath, String fileName)
	{
		this.clientPropertiesFilePath = filePath.replaceAll("%20", " ") + "\\" + fileName;
	}
	
	private Properties getServerProperties()
	{
		if(this.serverProperties == null)
		{
			try {
				this.serverProperties.load(new FileInputStream(this.serverPropertiesFilePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.serverProperties;
	}
	private Properties getClientProperties()
	{
		if(this.clientProperties == null)
		{
			try {
				this.clientProperties.load(new FileInputStream(this.clientPropertiesFilePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.clientProperties;
	}
	
	public String getServerProperty(String key)
	{
		return (String) this.getServerProperties().get(key);
	}
	public String getClientProperty(String key)
	{
		return (String) this.getClientProperties().get(key);
	}
	public Level getLogLevel()
	{
		return (Level) this.getServerProperties().get("LOG_LEVEL");
	}
}
