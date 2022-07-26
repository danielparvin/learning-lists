package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.PoemList;
import com.parvin.learninglists.model.works.Poem;
import com.parvin.learninglists.repository.lists.PoemListRepository;
import com.parvin.learninglists.repository.works.PoemRepository;

@Service
public final class PoemListService extends ListService<PoemListRepository, PoemRepository, PoemList, Poem> {

}
