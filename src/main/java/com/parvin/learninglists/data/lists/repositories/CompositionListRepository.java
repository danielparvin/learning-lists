package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.CompositionList;

public interface CompositionListRepository extends PagingAndSortingRepository<CompositionList, Long> {

}
