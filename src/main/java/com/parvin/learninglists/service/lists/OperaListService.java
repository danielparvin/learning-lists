package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.OperaList;
import com.parvin.learninglists.model.works.Opera;
import com.parvin.learninglists.repository.lists.OperaListRepository;
import com.parvin.learninglists.repository.works.OperaRepository;

@Service
public final class OperaListService extends ListService<OperaListRepository, OperaRepository, OperaList, Opera> {

}
