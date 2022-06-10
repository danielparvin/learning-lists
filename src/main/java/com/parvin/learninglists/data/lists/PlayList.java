package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.stage.Play;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PlayList extends LearningList<Play> {

}
