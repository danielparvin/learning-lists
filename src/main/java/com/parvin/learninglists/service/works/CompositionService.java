package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Composition;
import com.parvin.learninglists.repository.works.CompositionRepository;

@Service
public class CompositionService extends WorkService<CompositionRepository, Composition> {

}
