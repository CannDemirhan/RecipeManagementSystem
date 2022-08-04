package com.candemirhan.recipeapp.server.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.candemirhan.recipeapp.utils.HibernateUtil;


public interface CRUDable<T> {
	
	public abstract void create(T entity);
	public abstract ArrayList<T> retrieve();
	public abstract void update(long id, T entity);
	public abstract void delete(long id);
	
	public abstract T find(long id);

	public default Session dbConnectionViaHibernate()
	{
		return HibernateUtil.getSessionFactory().openSession();
	}
}
