package com.parvin.learninglists.model.works;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends Work {
	@ManyToOne
	private Person director;
	
	@ManyToMany
	@JoinTable(inverseJoinColumns = {@JoinColumn(name = "actor_id")})
	private List<Person> actors;
	
	private LocalDate releasedOn;
}
