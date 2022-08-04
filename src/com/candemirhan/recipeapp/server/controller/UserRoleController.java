package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.UserRole;

public class UserRoleController extends EntityController<UserRole>{
	
	@Override
	public void create(UserRole entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			
			System.out.println("UserRole is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
