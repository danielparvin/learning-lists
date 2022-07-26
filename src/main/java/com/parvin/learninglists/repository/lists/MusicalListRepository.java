package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.MusicalList;

@Repository
public interface MusicalListRepository extends PagingAndSortingRepository<MusicalList, Long> {

}
