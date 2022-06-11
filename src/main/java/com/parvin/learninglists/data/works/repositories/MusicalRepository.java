package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.musicalstage.Musical;

public interface MusicalRepository extends PagingAndSortingRepository<Musical, Long> {

}
