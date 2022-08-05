package com.candemirhan.recipeapp.server.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.candemirhan.recipeapp.server.controller.RecipeController;
import com.candemirhan.recipeapp.server.controller.UserController;
import com.candemirhan.recipeapp.server.dbo.Recipe;
import com.candemirhan.recipeapp.server.dbo.User;

public class CommonObject {

	private static CommonObject instance;
	
	private Map<String, User> userMap;
	private List<Recipe> recipeList;
	
	private CommonObject()
	{
		super();
	}
	
	public static CommonObject getInstance()
	{
		if(CommonObject.instance == null)
			CommonObject.instance = new CommonObject();
		return CommonObject.instance;
	}
	
	public User checkUserCredentials(String email, String password)
	{
		User user = this.getUserMap().get(email);
		
		if(user != null)
		{
			boolean correctPassword = user.getPassword().equals(password);
			if(!correctPassword)
				user = null;
		}
		return user;
	}
	private Map<String, User> getUserMap()
	{
		if(this.userMap == null)
			this.loadUsers();
		return this.userMap;
	}
	public List<Recipe> getRecipes() {
		if (this.recipeList == null) {
			this.loadRecipes();
		}
		return this.recipeList;
	}
	private void loadUsers()
	{
		this.userMap = new HashMap<>();
		
		UserController userController = new UserController();
		ArrayList<User> userList = userController.retrieve();
		
		for(User user : userList)
			this.userMap.put(user.getEmail(), user);
	}
	public void loadRecipes() {
		RecipeController  controller = new RecipeController();
		this.recipeList   = controller.retrieve();
	}
}
