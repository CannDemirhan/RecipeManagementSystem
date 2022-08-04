package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.RecipeType;

import jakarta.persistence.TypedQuery;

public class RecipeTypeController extends EntityController<RecipeType>{
	
	@Override
	public void create(RecipeType entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("RecipeType is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<RecipeType> retrieve() 
	{
		ArrayList<RecipeType> recipeTypeList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT recipeType FROM RecipeType as recipeType";
			TypedQuery<RecipeType> typedQuery = session.createQuery(hql,RecipeType.class);
			recipeTypeList = (ArrayList<RecipeType>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipeTypeList ;
	}

}
