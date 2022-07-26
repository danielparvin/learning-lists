package com.parvin.learninglists.services;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.data.lists.BalletList;
import com.parvin.learninglists.data.lists.repositories.BalletListRepository;
import com.parvin.learninglists.data.works.musicalstage.Ballet;
import com.parvin.learninglists.data.works.repositories.BalletRepository;

@Service
public final class BalletListService extends ListService<BalletListRepository, BalletRepository, BalletList, Ballet> {

}
