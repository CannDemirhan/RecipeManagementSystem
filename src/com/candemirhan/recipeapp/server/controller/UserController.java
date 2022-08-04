package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.User;

public class UserController extends EntityController<User>{
	
	@Override
	public void create(User entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("User is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
