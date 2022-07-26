package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.PlayList;

@Repository
public interface PlayListRepository extends PagingAndSortingRepository<PlayList, Long> {

}
