package com.parvin.learninglists.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.data.works.musicalstage.Opera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OperaList extends LearningList<Opera> {

}
