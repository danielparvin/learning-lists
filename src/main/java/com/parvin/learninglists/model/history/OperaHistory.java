package com.parvin.learninglists.model.history;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.model.works.Opera;

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
