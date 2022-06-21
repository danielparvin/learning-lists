package com.parvin.learninglists.data.general.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.general.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
