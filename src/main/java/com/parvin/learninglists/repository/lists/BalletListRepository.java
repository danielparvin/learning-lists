package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.BalletList;

@Repository
public interface BalletListRepository extends PagingAndSortingRepository<BalletList, Long> {

}
