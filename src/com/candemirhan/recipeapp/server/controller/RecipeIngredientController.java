package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.RecipeIngredient;

public class RecipeIngredientController extends EntityController<RecipeIngredient>{

	@Override
	public void create(RecipeIngredient entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			
			System.out.println("RecipeIngredient is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
