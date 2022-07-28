package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Poem;
import com.parvin.learninglists.repository.works.PoemRepository;

@Service
public class PoemService extends WorkService<PoemRepository, Poem> {

}
