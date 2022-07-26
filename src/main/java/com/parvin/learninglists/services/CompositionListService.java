package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.CompositionList;
import com.parvin.learninglists.data.lists.repositories.CompositionListRepository;
import com.parvin.learninglists.data.works.musical.Composition;
import com.parvin.learninglists.data.works.repositories.CompositionRepository;

@Service
public final class CompositionListService extends ListService<
	CompositionListRepository, CompositionRepository, CompositionList, Composition> {

}
