package com.candemirhan.recipeapp.server.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipes_ingredients")
public class RecipeIngredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	
	private int amount;
	
	@ManyToOne @Setter
	@JoinColumn(name = "unit_id")
	private Unit unit;
	
	@ManyToOne @Setter
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	@ManyToOne @Setter
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	

	public RecipeIngredient(int amount)
	{
		this.amount = amount;
	}
}
