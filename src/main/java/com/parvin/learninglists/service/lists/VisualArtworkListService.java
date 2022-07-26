package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.VisualArtworkList;
import com.parvin.learninglists.model.works.VisualArtwork;
import com.parvin.learninglists.repository.lists.VisualArtworkListRepository;
import com.parvin.learninglists.repository.works.VisualArtworkRepository;

@Service
public final class VisualArtworkListService 
	extends ListService<VisualArtworkListRepository, VisualArtworkRepository, VisualArtworkList, VisualArtwork> {

}
