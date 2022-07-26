package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.lists.MusicalList;

@Repository
public interface MusicalListRepository extends PagingAndSortingRepository<MusicalList, Long> {

}
