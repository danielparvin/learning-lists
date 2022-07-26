package com.parvin.learninglists.model.works;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class LiteraryWork extends Work {
	@ManyToOne
	private Person author;
}
