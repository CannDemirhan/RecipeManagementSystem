package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.RecipeRating;

public class RecipeRatingController extends EntityController<RecipeRating>{

	@Override
	public void create(RecipeRating entity) 
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			
			System.out.println("RecipeRating is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
}
