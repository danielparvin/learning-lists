package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.musicalstage.Musical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MusicalList extends LearningList<Musical> {

}
