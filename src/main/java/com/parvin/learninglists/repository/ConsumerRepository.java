package com.parvin.learninglists.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.parvin.learninglists.model.Consumer;

@Repository
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {

}
