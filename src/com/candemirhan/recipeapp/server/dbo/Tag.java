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
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private long tagId;
	
	private String name;
	
	@Column(length = 500)
	private String description;
	
	@OneToMany(mappedBy = "tag")
	private Set<RecipeTag> recipeTagSet;
	
	public Tag(String name, String description)
	{
		this.name = name;
		this.description = description;
		
		this.recipeTagSet = new HashSet<>();
	}
	
	public void addRecipeTagSet(RecipeTag recipeTag)
	{
		this.recipeTagSet.add(recipeTag);
	}
}
