package com.parvin.learninglists.data.works.literary;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.parvin.learninglists.data.Person;
import com.parvin.learninglists.data.works.Work;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class LiteraryWork extends Work {
	@ManyToOne
	private Person author;
}
