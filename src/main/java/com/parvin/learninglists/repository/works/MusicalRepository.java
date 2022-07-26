package com.parvin.learninglists.repository.works;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.works.Musical;

@Repository
public interface MusicalRepository extends PagingAndSortingRepository<Musical, Long> {

}
