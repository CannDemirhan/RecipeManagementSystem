package com.candemirhan.recipeapp.server.common;

import java.util.logging.Logger;

import com.candemirhan.recipeapp.utils.PropUtility;

public class ApplicationLogger {
	
	private static ApplicationLogger instance;
	private Logger logger;
	
	private ApplicationLogger() { super();}
	
	public static ApplicationLogger getInstance()
	{
		if(ApplicationLogger.instance == null)
			ApplicationLogger.instance = new ApplicationLogger();
		return ApplicationLogger.instance;
	}
	
	private Logger getLogger()
	{
		if(this.logger == null)
		{
			this.logger = Logger.getLogger("Recipe App Server Logger");
			this.logger.setLevel(PropUtility.getInstance().getLogLevel());
		}
		return this.logger;
	}

	public void logInfo(String message)
	{
		this.getLogger().info(message);
	}
	public void logWarning(String message)
	{
		this.getLogger().warning(message);
	}
	public void logError(String message)
	{
		this.getLogger().severe(message);
	}
}
