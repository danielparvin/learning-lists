package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.PlayList;
import com.parvin.learninglists.data.lists.repositories.PlayListRepository;
import com.parvin.learninglists.data.works.repositories.PlayRepository;
import com.parvin.learninglists.data.works.stage.Play;

@Service
public final class PlayListService extends ListService<PlayListRepository, PlayRepository, PlayList, Play> {

}
