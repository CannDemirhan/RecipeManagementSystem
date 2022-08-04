package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.Ingredient;

import jakarta.persistence.TypedQuery;

public class IngredientController extends EntityController<Ingredient>{

	@Override
	public void create(Ingredient entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("Ingredient is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Ingredient> retrieve() 
	{
		ArrayList<Ingredient> ingredientList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT ingredient FROM Ingredient as ingredient";
			TypedQuery<Ingredient> typedQuery = session.createQuery(hql,Ingredient.class);
			ingredientList = (ArrayList<Ingredient>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ingredientList ;
	}
}
