package com.parvin.learninglists.model.history;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.model.works.Poem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="poem_id"))
public class PoemHistory extends LiteraryHistory<Poem> {
	@JsonGetter("poem")
	@Override
	public Poem getWork() {
		return super.getWork();
	}
}
