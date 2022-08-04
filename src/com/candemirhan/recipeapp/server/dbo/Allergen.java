package com.candemirhan.recipeapp.server.dbo;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString(doNotUseGetters = true, exclude = "ingredients")
@Entity
@Table(name = "allergens")
public class Allergen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allergen_id")
	private long allergenId;
	
	@Setter
	private String name;
	
	@Setter
	private byte[] symbol;
	
	@ManyToMany(mappedBy = "allergens") @Setter
	private Collection<Ingredient> ingredients = new HashSet<>();
	
	
	public Allergen(String name)
	{
		this.name = name;
	}
	
	public void addIngredients(Ingredient ingredient)
	{
		this.ingredients.add(ingredient);
	}
	public Collection<Ingredient> getIngredients()
	{
		return this.ingredients;
	}
}
