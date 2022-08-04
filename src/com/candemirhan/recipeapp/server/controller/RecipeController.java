package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.Recipe;

import jakarta.persistence.TypedQuery;

public class RecipeController extends EntityController<Recipe>{

	@Override
	public void create(Recipe entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("Recipe is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Recipe> retrieve() 
	{
		ArrayList<Recipe> recipeList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT recipe FROM Recipe as recipe";
			TypedQuery<Recipe> typedQuery = session.createQuery(hql,Recipe.class);
			recipeList = (ArrayList<Recipe>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipeList ;
	}
}
