package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.musicalstage.Musical;

@Repository
public interface MusicalRepository extends PagingAndSortingRepository<Musical, Long> {

}
