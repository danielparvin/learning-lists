package com.parvin.learninglists.model.lists;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.parvin.learninglists.model.User;
import com.parvin.learninglists.model.works.Work;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class LearningList<T extends Work> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	private User createdBy;
	@OneToMany
	@JoinTable(joinColumns = {@JoinColumn(name = "list_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "work_id")})
	private List<T> works;
}
