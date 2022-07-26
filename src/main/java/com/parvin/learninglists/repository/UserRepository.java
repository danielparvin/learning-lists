package com.parvin.learninglists.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
