package com.parvin.learninglists.data.works;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.parvin.learninglists.data.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VisualArtwork extends Work {
	@ManyToOne
	private Person artist;
}
