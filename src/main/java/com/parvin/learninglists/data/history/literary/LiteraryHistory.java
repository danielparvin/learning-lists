package com.parvin.learninglists.data.history.literary;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.data.history.History;
import com.parvin.learninglists.data.works.literary.LiteraryWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@AttributeOverride(name = "consumedOn", column=@Column(name="readOn"))
public abstract class LiteraryHistory<T extends LiteraryWork> extends History<T>{
	@JsonGetter("readOn")
	@Override
	public LocalDate getConsumedOn() {
		return super.getConsumedOn();
	}
}
