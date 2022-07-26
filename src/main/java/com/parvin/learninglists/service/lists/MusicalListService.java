package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.MusicalList;
import com.parvin.learninglists.model.works.Musical;
import com.parvin.learninglists.repository.lists.MusicalListRepository;
import com.parvin.learninglists.repository.works.MusicalRepository;

@Service
public final class MusicalListService extends ListService<
	MusicalListRepository, MusicalRepository, MusicalList, Musical> {

}
