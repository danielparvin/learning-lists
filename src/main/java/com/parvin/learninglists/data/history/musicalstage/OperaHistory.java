package com.parvin.learninglists.data.history.musicalstage;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.works.musicalstage.Opera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="opera_id"))
public class OperaHistory extends MusicalStageHistory<Opera> {
	@JsonGetter("opera")
	@Override
	public Opera getWork() {
		return super.getWork();
	}
}
