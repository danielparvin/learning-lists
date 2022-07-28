package com.parvin.learninglists.service.works;

import org.springframework.stereotype.Service;

import com.parvin.learninglists.model.works.Play;
import com.parvin.learninglists.repository.works.PlayRepository;

@Service
public class PlayService extends WorkService<PlayRepository, Play> {

}
