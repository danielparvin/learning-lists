package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.CompositionList;
import com.parvin.learninglists.model.works.Composition;
import com.parvin.learninglists.repository.lists.CompositionListRepository;
import com.parvin.learninglists.repository.works.CompositionRepository;

@Service
public final class CompositionListService extends ListService<
	CompositionListRepository, CompositionRepository, CompositionList, Composition> {

}
