package com.parvin.learninglists.data.history.musicalstage;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.works.musicalstage.Ballet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="ballet_id"))
public class BalletHistory extends MusicalStageHistory<Ballet> {
	@JsonGetter("ballet")
	@Override
	public Ballet getWork() {
		return super.getWork();
	}
}
