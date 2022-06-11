package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.PoemList;

public interface PoemListRepository extends PagingAndSortingRepository<PoemList, Long> {

}
