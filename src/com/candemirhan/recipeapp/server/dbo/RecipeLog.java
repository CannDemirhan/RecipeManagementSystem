package com.candemirhan.recipeapp.server.dbo;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipes_logs")
public class RecipeLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long oid;
	
	@Column(name = "action_timestamp")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp actionTimestamp;
	
	@Column(name = "action_taken")
	private String actionTaken;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
}
