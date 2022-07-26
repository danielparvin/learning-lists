package com.parvin.learninglists.model.lists;

import javax.persistence.Entity;

import com.parvin.learninglists.model.works.Opera;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OperaList extends LearningList<Opera> {

}
