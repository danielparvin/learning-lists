package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.PoemList;

@Repository
public interface PoemListRepository extends PagingAndSortingRepository<PoemList, Long> {

}
