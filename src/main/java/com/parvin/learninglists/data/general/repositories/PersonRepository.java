package com.parvin.learninglists.data.general.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.general.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
