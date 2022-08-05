package com.candemirhan.recipeapp.common;

public enum Role {
	
	SUPERUSER("SuperAdmin"), 
	ADMIN("Admin"), 
	USER("User"), 
	CORDONBLUE("CordonBlue"), 
	NOT_DEFINED("Not defined");

	private String roleName;

	Role(String roleName) {
		this.roleName = roleName;
	}
	
	public static Role getRole(String roleName) {
		if (SUPERUSER.roleName.equalsIgnoreCase(roleName))
			return SUPERUSER;
		if (ADMIN.roleName.equalsIgnoreCase(roleName))
			return ADMIN;
		if (USER.roleName.equalsIgnoreCase(roleName))
			return USER;
		if(CORDONBLUE.roleName.equalsIgnoreCase(roleName))
			return CORDONBLUE;
		return NOT_DEFINED;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
}
