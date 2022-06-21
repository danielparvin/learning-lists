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

import com.parvin.learninglists.data.general.Consumer;
import com.parvin.learninglists.data.general.repositories.ConsumerRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/consumer",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON
				)
public class ConsumerController {
	@Autowired
	private ConsumerRepository consumerRepo;
	
	@PostMapping
	public ResponseEntity<Consumer> create(@RequestBody Consumer consumer) {
		return ResponseEntity.ok(consumerRepo.save(consumer));
	}

	@GetMapping
	public ResponseEntity<Page<Consumer>> getConsumers(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(consumerRepo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Consumer> getConsumer(@PathVariable("id") Long id) {
		Optional<Consumer> optionalConsumer = consumerRepo.findById(id);
		if (optionalConsumer.isPresent()) {
			return ResponseEntity.ok(optionalConsumer.get());
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Consumer> update(@RequestBody Consumer newConsumer, @PathVariable Long id) {
		Consumer updatedConsumer = consumerRepo.findById(id)
				.map(person -> {
					person.setFirstName(newConsumer.getFirstName());
					person.setLastName(newConsumer.getLastName());
					person.setAlias(newConsumer.getAlias());
					return consumerRepo.save(person);
				})
				.orElseGet(() -> {
					newConsumer.setId(id);
					return consumerRepo.save(newConsumer);
				});
		return ResponseEntity.ok(updatedConsumer);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Consumer> delete(@PathVariable("id") Long id) {
		Optional<Consumer> optionalConsumer = consumerRepo.findById(id);
		if (optionalConsumer.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			consumerRepo.deleteById(id);
			return ResponseEntity.ok(optionalConsumer.get());
		}
	}
}
