package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.lists.BalletList;

@Repository
public interface BalletListRepository extends PagingAndSortingRepository<BalletList, Long> {

}
