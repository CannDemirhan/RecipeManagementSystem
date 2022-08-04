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
@Table(name = "recipes_tags")
public class RecipeTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	
	@ManyToOne @Setter
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne @Setter
	@JoinColumn(name = "tag_id")
	private Tag tag;

}
