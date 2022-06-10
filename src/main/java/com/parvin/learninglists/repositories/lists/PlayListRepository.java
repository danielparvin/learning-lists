package com.parvin.learninglists.repositories.lists;

import org.springframework.data.repository.CrudRepository;

import com.parvin.learninglists.data.lists.PlayList;

public interface PlayListRepository extends CrudRepository<PlayList, Long> {

}
