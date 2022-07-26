package com.parvin.learninglists.model.history;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.model.works.VisualArtwork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="visual_artwork_id"))
@AttributeOverride(name = "consumedOn", column=@Column(name="observedOn"))
public class VisualArtworkHistory extends History<VisualArtwork> {
	@JsonGetter("visual_artwork")
	@Override
	public VisualArtwork getWork() {
		return super.getWork();
	}
	
	@JsonGetter("observedOn")
	@Override
	public LocalDate getConsumedOn() {
		return super.getConsumedOn();
	}
}
