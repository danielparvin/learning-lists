package com.parvin.learninglists.api;

import static com.parvin.learninglists.Constants.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping
	public ResponseEntity<Page<Person>> getPersons( // TODO Add default sort direction.
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(personRepo.findAll(PageRequest.of(pageSize, pageNumber, Sort.by(sortBy))));
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
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> updatePersonById(@RequestBody Person newPerson, @PathVariable Long id) {
		Person updatedPerson = personRepo.findById(id)
				.map(person -> {
					person.setBirthDate(newPerson.getBirthDate());
					person.setDeathDate(newPerson.getDeathDate());
					person.setFirstName(newPerson.getFirstName());
					person.setLastName(newPerson.getLastName());
					person.setSex(newPerson.getSex());
					return personRepo.save(person);
				})
				.orElseGet(() -> {
					newPerson.setId(id);
					return personRepo.save(newPerson);
				});
		return ResponseEntity.ok(updatedPerson);
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
