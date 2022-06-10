package com.parvin.learninglists.repositories.lists;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.PoemList;

public interface PoemListRepository extends CrudRepository<PoemList, Long> {

}
