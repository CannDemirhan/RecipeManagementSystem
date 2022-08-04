package com.candemirhan.recipeapp.server.dbo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipe_id")
	private long recipeId;

	private String  name;
	
	@Column(length = 500)
	private String  description;
	private int     servings;
	@Column(name = "calories_per_servinng")
	private int 	caloriesPerServing;
	private boolean isApproved;
	
	@OneToMany(mappedBy = "recipe")
	private Set<Step> steps;
	
	@OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL)
	private Set<RecipeIngredient> recipeIngredientSet;
	
	@OneToMany(mappedBy = "recipe")
	private Set<RecipeRating> recipeRatingSet;
	
	
	
	@ManyToOne
	@JoinColumn(name = "recipe_type_id", referencedColumnName = "recipe_type_id")
	@Setter
	private RecipeType recipeType;
	
	public Recipe(String name, String description, int servings, int caloriesPerServing, boolean isApproved)
	{
		this.name = name;
		this.description = description;
		this.servings = servings;
		this.caloriesPerServing = caloriesPerServing;
		this.isApproved = isApproved;
		
		this.steps = new HashSet<>();
		this.recipeIngredientSet = new HashSet<>();
		this.recipeRatingSet = new HashSet<>();
	}
	
	public void addStepSet(Step step)
	{
		this.steps.add(step);
	}
	public void addRecipeIngredientSet(RecipeIngredient RecipeIngredient)
	{
		this.recipeIngredientSet.add(RecipeIngredient);
	}
	public void addRecipeRatingSet(RecipeRating recipeRating)
	{
		this.recipeRatingSet.add(recipeRating);
	}
}
