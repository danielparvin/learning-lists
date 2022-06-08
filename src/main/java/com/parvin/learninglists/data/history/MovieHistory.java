package com.parvin.learninglists.data.history;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.works.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="movie_id"))
@AttributeOverride(name = "consumedOn", column=@Column(name="watchedOn"))
public class MovieHistory extends History<Movie> {
	@JsonGetter("movie")
	@Override
	public Movie getWork() {
		return super.getWork();
	}
	
	@JsonGetter("watchedOn")
	@Override
	public LocalDate getConsumedOn() {
		return super.getConsumedOn();
	}
}
