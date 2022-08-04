package com.candemirhan.recipeapp.server.dbo;

import jakarta.persistence.Column;
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
@Table(name = "steps")
public class Step {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "step_id")
	private long stepId;

	@Column(name = "step_no")
	private int stepNo;

	@Column(length = 500)
	private String description;
	private int duration;

	@Column(name = "duration_unit")
	private String durationUnit;

	@ManyToOne
	@JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id")
	@Setter
	private Recipe recipe;

	public Step(int stepNo, String description, int duration, String durationUnit)
	{
		this.stepNo = stepNo;
		this.description = description;
		this.duration = duration;
		this.durationUnit = durationUnit;
	}
}
