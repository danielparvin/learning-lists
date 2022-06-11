package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.MusicalList;

public interface MusicalListRepository extends PagingAndSortingRepository<MusicalList, Long> {

}
