package com.candemirhan.recipeapp.server.controller;

import org.hibernate.Session;

import com.candemirhan.recipeapp.server.dbo.Tag;

public class TagController extends EntityController<Tag> {

	@Override
	public void create(Tag entity)
	{
		try(Session session = dbConnectionViaHibernate())
		{
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			System.out.println("Tag is Added to DB " + entity);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
