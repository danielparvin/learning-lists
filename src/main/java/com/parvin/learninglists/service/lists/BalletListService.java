package com.parvin.learninglists.service.lists;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.lists.BalletList;
import com.parvin.learninglists.model.works.Ballet;
import com.parvin.learninglists.repository.lists.BalletListRepository;
import com.parvin.learninglists.repository.works.BalletRepository;

@Service
public final class BalletListService extends ListService<BalletListRepository, BalletRepository, BalletList, Ballet> {

}
