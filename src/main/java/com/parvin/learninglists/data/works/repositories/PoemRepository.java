package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.works.literary.Poem;

public interface PoemRepository extends CrudRepository<Poem, Long> {

}
