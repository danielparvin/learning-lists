package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.VisualArtwork;

@Repository
public interface VisualArtworkHistoryRepository extends PagingAndSortingRepository<VisualArtwork, Long> {

}
