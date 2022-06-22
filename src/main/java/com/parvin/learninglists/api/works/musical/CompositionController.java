package com.parvin.learninglists.api.works.musical;

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

import com.parvin.learninglists.data.works.musical.Composition;
import com.parvin.learninglists.data.works.repositories.CompositionRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/composition",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class CompositionController {
	@Autowired
	private CompositionRepository repo;

	@PostMapping
	public ResponseEntity<Composition> create(@RequestBody Composition composition) {
		return ResponseEntity.ok(repo.save(composition));
	}

	@GetMapping
	public ResponseEntity<Page<Composition>> getCompositions(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Composition> getComposition(@PathVariable("id") Long id) {
		Optional<Composition> optionalComposition = repo.findById(id);
		if (optionalComposition.isPresent()) {
			return ResponseEntity.ok(optionalComposition.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Composition> update(@RequestBody Composition newComposition, @PathVariable Long id) {
		Composition updatedComposition = repo.findById(id)
				.map(composition -> {
					composition.setComposer(newComposition.getComposer());
					composition.setTitle(newComposition.getTitle());
					return repo.save(composition);
				})
				.orElseGet(() -> {
					newComposition.setId(id);
					return repo.save(newComposition);
				});
		return ResponseEntity.ok(updatedComposition);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Composition> delete(@PathVariable("id") Long id) {
		Optional<Composition> optionalComposition = repo.findById(id);
		if (optionalComposition.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalComposition.get());
		}
	}
}
