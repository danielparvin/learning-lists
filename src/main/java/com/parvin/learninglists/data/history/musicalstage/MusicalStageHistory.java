package com.parvin.learninglists.data.history.musicalstage;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.history.History;
import com.parvin.learninglists.data.works.musicalstage.MusicalStageWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@AttributeOverride(name = "consumedOn", column=@Column(name="watchedOn"))
public abstract class MusicalStageHistory<T extends MusicalStageWork> extends History<T> {
	@JsonGetter("watchedOn")
	@Override
	public LocalDate getConsumedOn() {
		return super.getConsumedOn();
	}
}
