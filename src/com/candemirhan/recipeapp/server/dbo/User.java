package com.candemirhan.recipeapp.server.dbo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "first_name", length = 100)
	private String firstName;
	
	@Column(name = "last_name", length = 100)
	private String lastName;
	@Column(length = 100)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(precision = 1)
	private double rating;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserRole> userRoleSet;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<RecipeTag> recipeTagSet;

	public User(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = this.firstName.split(" ")[0].toLowerCase() + "@ba.com";
		this.password = "abc";
		this.rating = 4.0;
		
		this.userRoleSet = new HashSet<>();
		this.recipeTagSet = new HashSet<>();
	}
	
	public void addUserRoleSet(UserRole userRole)
	{
		this.userRoleSet.add(userRole);
	}
	public void addRecipeTagSet(RecipeTag recipeTag)
	{
		this.recipeTagSet.add(recipeTag);
	}
}
