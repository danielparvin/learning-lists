package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.literary.Poem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PoemList extends LearningList<Poem> {

}
