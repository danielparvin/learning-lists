package com.parvin.learninglists.data.history.musicalstage;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.works.musicalstage.Musical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="musical_id"))
public class MusicalHistory extends MusicalStageHistory<Musical> {
	@JsonGetter("musical")
	@Override
	public Musical getWork() {
		return super.getWork();
	}
}
