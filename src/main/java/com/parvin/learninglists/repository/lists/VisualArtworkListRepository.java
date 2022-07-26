package com.parvin.learninglists.repository.lists;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.lists.VisualArtworkList;

@Repository
public interface VisualArtworkListRepository extends PagingAndSortingRepository<VisualArtworkList, Long> {

}
