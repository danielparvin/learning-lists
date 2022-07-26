package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.OperaList;
import com.parvin.learninglists.data.lists.repositories.OperaListRepository;
import com.parvin.learninglists.data.works.musicalstage.Opera;
import com.parvin.learninglists.data.works.repositories.OperaRepository;

@Service
public final class OperaListService extends ListService<OperaListRepository, OperaRepository, OperaList, Opera> {

}
