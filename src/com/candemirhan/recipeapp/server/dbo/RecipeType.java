package com.candemirhan.recipeapp.server.dbo;

import java.util.Collection;
import java.util.HashSet;

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
@Table(name = "recipe_types")
public class RecipeType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_type_id")
	private long recipeTypeId;
	
	private String name;
	
	@OneToMany(mappedBy = "recipeType")
	private Collection<Recipe> recipes;
	
	public RecipeType(String name)
	{
		this.name = name;
		this.recipes = new HashSet<>();
	}
	
	public void addRecipes(Recipe recipe)
	{
		this.recipes.add(recipe);
	}
}
