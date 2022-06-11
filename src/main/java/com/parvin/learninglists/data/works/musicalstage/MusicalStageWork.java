package com.parvin.learninglists.data.works.musicalstage;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.parvin.learninglists.data.general.Person;
import com.parvin.learninglists.data.works.Work;

@MappedSuperclass
public abstract class MusicalStageWork extends Work {
	@ManyToOne
	private Person composer;
}
