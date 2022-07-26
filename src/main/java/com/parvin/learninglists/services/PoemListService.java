package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.PoemList;
import com.parvin.learninglists.data.lists.repositories.PoemListRepository;
import com.parvin.learninglists.data.works.literary.Poem;
import com.parvin.learninglists.data.works.repositories.PoemRepository;

@Service
public final class PoemListService extends ListService<PoemListRepository, PoemRepository, PoemList, Poem> {

}
