package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Musical;
import com.parvin.learninglists.repository.works.MusicalRepository;

@Service
public class MusicalService extends WorkService<MusicalRepository, Musical> {

}
