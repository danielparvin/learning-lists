package com.parvin.learninglists.model.history;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.parvin.learninglists.model.works.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AssociationOverride(name = "work", joinColumns=@JoinColumn(name="book_id"))
public class BookHistory extends LiteraryHistory<Book> {
	@JsonGetter("book")
	@Override
	public Book getWork() {
		return super.getWork();
	}
}
