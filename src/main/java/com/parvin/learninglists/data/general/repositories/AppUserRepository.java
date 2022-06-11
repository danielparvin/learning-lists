package com.parvin.learninglists.data.general.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.general.AppUser;

public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

}
