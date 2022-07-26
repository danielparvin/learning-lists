package com.parvin.learninglists.model.works;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.parvin.learninglists.model.Sex;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String lastName;
	private String firstName;
	private Sex sex;
	private LocalDate birthDate;
	private LocalDate deathDate;
}
