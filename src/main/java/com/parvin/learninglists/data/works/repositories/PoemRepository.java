package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.literary.Poem;

public interface PoemRepository extends PagingAndSortingRepository<Poem, Long> {

}
