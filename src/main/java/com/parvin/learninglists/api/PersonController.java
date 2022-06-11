package com.parvin.learninglists.api;

import static com.parvin.learninglists.Constants.API_BASE;
import static com.parvin.learninglists.Constants.APPLICATION_JSON;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parvin.learninglists.data.general.Person;
import com.parvin.learninglists.data.general.repositories.PersonRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/person",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON
				)
public class PersonController {
	@Autowired
	PersonRepository personRepo;
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		return ResponseEntity.ok(personRepo.save(person));
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if (optionalPerson.isPresent()) {
			return ResponseEntity.ok(optionalPerson.get());
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Person> deletePersonById(@PathVariable("id") Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if (optionalPerson.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			personRepo.deleteById(id);
			return ResponseEntity.ok(optionalPerson.get());
		}
	}
}
