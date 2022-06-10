package com.parvin.learninglists.repositories.works;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.works.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
