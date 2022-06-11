package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.stage.Play;

public interface PlayRepository extends PagingAndSortingRepository<Play, Long> {

}
