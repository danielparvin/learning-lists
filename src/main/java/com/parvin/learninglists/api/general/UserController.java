package com.parvin.learninglists.api.general;

import static com.parvin.learninglists.Constants.API_BASE;
import static com.parvin.learninglists.Constants.APPLICATION_JSON;
import static com.parvin.learninglists.Constants.DEFAULT_PAGE_NUMBER_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_PAGE_SIZE_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_SORT_BY_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_SORT_DIRECTION_STRING;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import com.parvin.learninglists.data.general.User;
import com.parvin.learninglists.data.general.repositories.UserRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/user",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON
				)
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(userRepo.save(user));
	}

	@GetMapping
	public ResponseEntity<Page<User>> getUsers(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(userRepo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody User newUser, @PathVariable Long id) {
		User updatedUser = userRepo.findById(id)
				.map(person -> {
					person.setFirstName(newUser.getFirstName());
					person.setLastName(newUser.getLastName());
					person.setAlias(newUser.getAlias());
					return userRepo.save(person);
				})
				.orElseGet(() -> {
					newUser.setId(id);
					return userRepo.save(newUser);
				});
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			userRepo.deleteById(id);
			return ResponseEntity.ok(optionalUser.get());
		}
	}
}
