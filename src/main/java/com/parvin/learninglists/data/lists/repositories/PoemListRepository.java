package com.parvin.learninglists.data.lists.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.PoemList;

public interface PoemListRepository extends CrudRepository<PoemList, Long> {

}
