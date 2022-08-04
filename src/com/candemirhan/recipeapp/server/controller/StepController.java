package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.Step;

import jakarta.persistence.TypedQuery;

public class StepController extends EntityController<Step>{
	
	@Override
	public void create(Step entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("Step is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Step> retrieve() 
	{
		ArrayList<Step> stepList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT step FROM Step as step";
			TypedQuery<Step> typedQuery = session.createQuery(hql,Step.class);
			stepList = (ArrayList<Step>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stepList ;
	}

}
