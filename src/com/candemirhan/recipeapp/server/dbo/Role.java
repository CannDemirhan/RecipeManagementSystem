package com.candemirhan.recipeapp.server.dbo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleId;
	
	private String name;
	
	@OneToMany(mappedBy = "role")
	private Set<UserRole> userRoleSet;
	
	public Role(String name)
	{
		this.name = name;
		this.userRoleSet = new HashSet<>();
	}
	
	public void addUserRoleSet(UserRole userRole)
	{
		this.userRoleSet.add(userRole);
	}
}
