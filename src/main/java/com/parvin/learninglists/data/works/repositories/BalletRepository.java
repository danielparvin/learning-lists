package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.musicalstage.Ballet;

@Repository
public interface BalletRepository extends PagingAndSortingRepository<Ballet, Long> {

}
