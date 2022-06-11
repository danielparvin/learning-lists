package com.parvin.learninglists.data.general.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.general.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
