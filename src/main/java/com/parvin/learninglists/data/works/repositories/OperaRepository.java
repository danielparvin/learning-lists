package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.musicalstage.Opera;

@Repository
public interface OperaRepository extends PagingAndSortingRepository<Opera, Long> {

}
