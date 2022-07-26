package com.parvin.learninglists.repository.works;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.works.Play;

@Repository
public interface PlayRepository extends PagingAndSortingRepository<Play, Long> {

}
