package com.parvin.learninglists.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;

/**
 * Represents a user of the app. A single user can manage multiple consumers.
 */
@Getter
@Setter
@Entity(name = "app_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String alias;
	@OneToOne
	private Consumer defaultConsumer;
}
