package com.parvin.learninglists.data.lists.dtos;

import com.parvin.learninglists.data.general.User;
import com.parvin.learninglists.data.lists.LearningList;
import com.parvin.learninglists.data.works.Work;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LearningListSummary {
	private Long id;
	private String name;
	private User createdBy;
	private Integer numberOfWorks;
	
	public LearningListSummary() {}
	
	public LearningListSummary(LearningList<? extends Work> list) {
		this.id = list.getId();
		this.name = list.getName();
		this.createdBy = list.getCreatedBy();
		this.numberOfWorks = list.getWorks().size();
	}
}
