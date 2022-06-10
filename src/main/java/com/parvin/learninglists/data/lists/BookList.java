package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.literary.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookList extends LearningList<Book> {

}
