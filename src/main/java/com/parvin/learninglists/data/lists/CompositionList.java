package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.musical.Composition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CompositionList extends LearningList<Composition> {

}
