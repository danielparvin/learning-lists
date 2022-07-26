package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.literary.Poem;

@Repository
public interface PoemRepository extends PagingAndSortingRepository<Poem, Long> {

}
