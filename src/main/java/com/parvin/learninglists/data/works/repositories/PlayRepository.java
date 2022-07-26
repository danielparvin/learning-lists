package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.stage.Play;

@Repository
public interface PlayRepository extends PagingAndSortingRepository<Play, Long> {

}
