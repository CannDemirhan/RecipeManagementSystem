package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.Allergen;

import jakarta.persistence.TypedQuery;

public class AllergenController extends EntityController<Allergen>{

	@Override
	public void create(Allergen entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("Allergen is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Allergen> retrieve()
	{
		ArrayList<Allergen> allergenList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT allergen FROM Allergen as allergen";
			TypedQuery<Allergen> typedQuery = session.createQuery(hql,Allergen.class);
			allergenList = (ArrayList<Allergen>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allergenList;
	}
	
	
	
	

}
