package com.candemirhan.recipeapp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.candemirhan.recipeapp.server.dbo.Allergen;
import com.candemirhan.recipeapp.server.dbo.Ingredient;
import com.candemirhan.recipeapp.server.dbo.Recipe;
import com.candemirhan.recipeapp.server.dbo.RecipeIngredient;
import com.candemirhan.recipeapp.server.dbo.RecipeTag;
import com.candemirhan.recipeapp.server.dbo.RecipeType;
import com.candemirhan.recipeapp.server.dbo.Role;
import com.candemirhan.recipeapp.server.dbo.Step;
import com.candemirhan.recipeapp.server.dbo.Tag;
import com.candemirhan.recipeapp.server.dbo.Unit;
import com.candemirhan.recipeapp.server.dbo.User;
import com.candemirhan.recipeapp.server.dbo.UserRole;

public class HibernateUtil {
	
private static final SessionFactory sessionFactory = sessionFactory();
	
	private static SessionFactory sessionFactory() {
		
		SessionFactory factory = null;
		
		try {
		
		Configuration config = new Configuration();
		
		// Make configurations
		config.addAnnotatedClass(Ingredient.class);
		config.addAnnotatedClass(Allergen.class);
		config.addAnnotatedClass(Step.class);
		config.addAnnotatedClass(Recipe.class);
		config.addAnnotatedClass(RecipeType.class);
		config.addAnnotatedClass(Unit.class);
		config.addAnnotatedClass(RecipeIngredient.class);
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Role.class);
		config.addAnnotatedClass(UserRole.class);
		config.addAnnotatedClass(Tag.class);
		config.addAnnotatedClass(RecipeTag.class);
		
		factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
