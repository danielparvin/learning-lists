package com.parvin.learninglists.controller.works;

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

import com.parvin.learninglists.model.works.Poem;
import com.parvin.learninglists.repository.works.PoemRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/poem",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class PoemController {
	@Autowired
	private PoemRepository repo;

	@PostMapping
	public ResponseEntity<Poem> create(@RequestBody Poem poem) {
		return ResponseEntity.ok(repo.save(poem));
	}

	@GetMapping
	public ResponseEntity<Page<Poem>> getPoems(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Poem> getPoem(@PathVariable("id") Long id) {
		Optional<Poem> optionalPoem = repo.findById(id);
		if (optionalPoem.isPresent()) {
			return ResponseEntity.ok(optionalPoem.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Poem> update(@RequestBody Poem newPoem, @PathVariable Long id) {
		Poem updatedPoem = repo.findById(id)
				.map(poem -> {
					poem.setAuthor(newPoem.getAuthor());
					poem.setTitle(newPoem.getTitle());
					return repo.save(poem);
				})
				.orElseGet(() -> {
					newPoem.setId(id);
					return repo.save(newPoem);
				});
		return ResponseEntity.ok(updatedPoem);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Poem> delete(@PathVariable("id") Long id) {
		Optional<Poem> optionalPoem = repo.findById(id);
		if (optionalPoem.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalPoem.get());
		}
	}
}
