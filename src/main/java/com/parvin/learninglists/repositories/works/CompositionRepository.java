package com.parvin.learninglists.repositories.works;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.works.musical.Composition;

public interface CompositionRepository extends CrudRepository<Composition, Long> {

}
