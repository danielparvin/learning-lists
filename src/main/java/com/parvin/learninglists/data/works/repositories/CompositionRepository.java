package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.musical.Composition;

public interface CompositionRepository extends PagingAndSortingRepository<Composition, Long> {

}
