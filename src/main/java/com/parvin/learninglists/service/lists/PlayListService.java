package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.PlayList;
import com.parvin.learninglists.model.works.Play;
import com.parvin.learninglists.repository.lists.PlayListRepository;
import com.parvin.learninglists.repository.works.PlayRepository;

@Service
public final class PlayListService extends ListService<PlayListRepository, PlayRepository, PlayList, Play> {

}
