package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.OperaList;

@Repository
public interface OperaListRepository extends PagingAndSortingRepository<OperaList, Long> {

}
