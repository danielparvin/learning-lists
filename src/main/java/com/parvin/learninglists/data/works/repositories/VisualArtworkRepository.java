package com.parvin.learninglists.data.works.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.works.VisualArtwork;

@Repository
public interface VisualArtworkRepository extends PagingAndSortingRepository<VisualArtwork, Long> {

}
