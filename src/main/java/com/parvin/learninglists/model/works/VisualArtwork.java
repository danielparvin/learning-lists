package com.parvin.learninglists.model.works;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VisualArtwork extends Work {
	@ManyToOne
	private Person artist;
}
