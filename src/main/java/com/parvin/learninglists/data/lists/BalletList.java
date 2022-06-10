package com.parvin.learninglists.data.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.musicalstage.Ballet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BalletList extends LearningList<Ballet> {

}
