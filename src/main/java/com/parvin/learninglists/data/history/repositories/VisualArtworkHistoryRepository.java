package com.parvin.learninglists.data.history.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.works.VisualArtwork;

public interface VisualArtworkHistoryRepository extends PagingAndSortingRepository<VisualArtwork, Long> {

}
