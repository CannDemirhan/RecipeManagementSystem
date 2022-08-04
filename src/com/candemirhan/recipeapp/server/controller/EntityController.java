package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

public class EntityController<T> implements CRUDable<T>{

	@Override
	public void create(T entity) 
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println(entity.getClass().getCanonicalName() + " is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<T> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
