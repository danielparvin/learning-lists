package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.Movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MovieList extends LearningList<Movie> {

}
