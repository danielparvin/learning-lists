package com.parvin.learninglists.model.history;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.model.works.Play;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="play_id"))
@AttributeOverride(name = "consumedOn", column=@Column(name="watchedOn"))
public class PlayHistory extends History<Play> {
	@JsonGetter("play")
	@Override
	public Play getWork() {
		return super.getWork();
	}
	
	@JsonGetter("watchedOn")
	@Override
	public LocalDate getConsumedOn() {
		return super.getConsumedOn();
	}
}
