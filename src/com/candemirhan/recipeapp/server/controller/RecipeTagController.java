package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.RecipeTag;
public class RecipeTagController extends EntityController<RecipeTag>{
	
	@Override
	public void create(RecipeTag entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			
			System.out.println("RecipeTag is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
