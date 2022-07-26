package com.parvin.learninglists.model.history;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.parvin.learninglists.model.Consumer;
import com.parvin.learninglists.model.works.Work;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class History<T extends Work> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Consumer consumer;
	@ManyToOne
	@JsonAlias({"composition", "book", "poem", "movie", "artwork"})
	private T work;
	@JsonAlias({"listenedOn", "readOn", "observedOn"})
	private LocalDate consumedOn;
}
