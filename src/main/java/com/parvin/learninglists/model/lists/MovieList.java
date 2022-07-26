package com.parvin.learninglists.model.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.model.works.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MovieList extends LearningList<Movie> {

}
