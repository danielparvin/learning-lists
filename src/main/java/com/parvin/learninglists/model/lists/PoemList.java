package com.parvin.learninglists.model.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.model.works.Poem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PoemList extends LearningList<Poem> {

}
