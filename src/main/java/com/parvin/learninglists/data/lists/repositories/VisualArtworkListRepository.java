package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.lists.VisualArtworkList;

@Repository
public interface VisualArtworkListRepository extends PagingAndSortingRepository<VisualArtworkList, Long> {

}
