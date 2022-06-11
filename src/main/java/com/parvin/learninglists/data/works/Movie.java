package com.parvin.learninglists.data.works;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.parvin.learninglists.data.general.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends Work {
	@ManyToOne
	private Person director;
}
