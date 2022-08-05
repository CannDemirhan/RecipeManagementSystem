package com.candemirhan.recipeapp.client.common;

import java.util.ArrayList;
import java.util.List;

import com.candemirhan.recipeapp.common.Role;


public class CommonObject {
	
	private static CommonObject instance;
	private List<Role> roleList;
	
	private CommonObject() {super();};
	
	public static CommonObject getInstance()
	{
		if (CommonObject.instance == null) {
			CommonObject.instance = new CommonObject();
		}
		return CommonObject.instance;
	}

	public List<Role> getRoles()
	{
		if(this.roleList == null)
			roleList = new ArrayList<>();
		return roleList;
	}
	
	public void addRole(String roleName)
	{
		this.getRoles().add(Role.getRole(roleName));
	}
	public boolean hasRole(Role role)
	{
		return this.getRoles().contains(role);
	}
	public boolean hasSuperAdminRole() 
	{
		return this.getRoles().contains(Role.SUPERUSER);
	}

	public boolean hasAdminRole() 
	{
		return this.getRoles().contains(Role.ADMIN);
	}

	public boolean hasUserRole() 
	{
		return this.getRoles().contains(Role.USER);
	}

	public boolean hasCordonBlueRole() 
	{
		return this.getRoles().contains(Role.CORDONBLUE);
	} 
}
