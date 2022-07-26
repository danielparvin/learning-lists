package com.parvin.learninglists.repository.history;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.works.VisualArtwork;

@Repository
public interface VisualArtworkHistoryRepository extends PagingAndSortingRepository<VisualArtwork, Long> {

}
