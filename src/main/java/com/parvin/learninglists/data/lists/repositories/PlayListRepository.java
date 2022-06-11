package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.lists.PlayList;

public interface PlayListRepository extends PagingAndSortingRepository<PlayList, Long> {

}
