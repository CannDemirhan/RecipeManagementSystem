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
@Table(name = "units")
public class Unit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id")
	private long unitId;
	
	private String name;
	
	@OneToMany(mappedBy = "unit")
	private Set<RecipeIngredient> recipeIngredients;
	
	public Unit(String name)
	{
		this.name = name;
		this.recipeIngredients = new HashSet<>();
	}
	
	public void addRecipeIngredients(RecipeIngredient recipeIngredient)
	{
		this.recipeIngredients.add(recipeIngredient);
	}
}
