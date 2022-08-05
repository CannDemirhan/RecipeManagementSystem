package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.User;

import jakarta.persistence.TypedQuery;

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
	@Override
	public ArrayList<User> retrieve() 
	{
		ArrayList<User> userList = null;
		
		try(Session session = dbConnectionViaHibernate()){
			
			String hql = "SELECT user FROM User as user";
			TypedQuery<User> typedQuery = session.createQuery(hql,User.class);
			userList = (ArrayList<User>) typedQuery.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userList;
	}
}
