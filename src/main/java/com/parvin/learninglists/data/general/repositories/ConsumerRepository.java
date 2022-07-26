package com.parvin.learninglists.data.general.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.data.general.Consumer;

@Repository
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {

}
