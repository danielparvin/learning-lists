package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.VisualArtworkList;
import com.parvin.learninglists.data.lists.repositories.VisualArtworkListRepository;
import com.parvin.learninglists.data.works.VisualArtwork;
import com.parvin.learninglists.data.works.repositories.VisualArtworkRepository;

@Service
public final class VisualArtworkListService 
	extends ListService<VisualArtworkListRepository, VisualArtworkRepository, VisualArtworkList, VisualArtwork> {

}
