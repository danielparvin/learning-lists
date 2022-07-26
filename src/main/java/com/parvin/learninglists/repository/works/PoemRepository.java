package com.parvin.learninglists.repository.works;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.works.Poem;

@Repository
public interface PoemRepository extends PagingAndSortingRepository<Poem, Long> {

}
