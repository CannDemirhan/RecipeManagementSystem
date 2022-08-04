
package com.candemirhan.recipeapp.server.dbo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ingredient_id")
	private long ingredientId;
	@Setter
	private String name;
	
	@ManyToMany 
	@JoinTable(name = "ingredients_allergens", joinColumns = {@JoinColumn(name = "ingredient_id")}, inverseJoinColumns = {@JoinColumn(name = "allergen_id")})
	private Set<Allergen> allergens;
	
	@OneToMany(mappedBy = "ingredient")
	private Set<RecipeIngredient> recipeIngredients;
	
	public Ingredient(String name)
	{
		this.name = name;
		this.allergens = new HashSet<>();
		this.recipeIngredients = new HashSet<>();
	}
	
	public void addAllergens(Allergen allergen)
	{
		this.allergens.add(allergen);
	}
	public Collection<Allergen> getAllergens()
	{
		return this.allergens;
	}
	public void addRecipeIngredients(RecipeIngredient recipeIngredient)
	{
		this.recipeIngredients.add(recipeIngredient);
	}
}
