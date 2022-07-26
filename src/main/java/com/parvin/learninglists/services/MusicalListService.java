package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.MusicalList;
import com.parvin.learninglists.data.lists.repositories.MusicalListRepository;
import com.parvin.learninglists.data.works.musicalstage.Musical;
import com.parvin.learninglists.data.works.repositories.MusicalRepository;

@Service
public final class MusicalListService extends ListService<
	MusicalListRepository, MusicalRepository, MusicalList, Musical> {

}
