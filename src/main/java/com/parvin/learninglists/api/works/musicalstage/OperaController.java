package com.parvin.learninglists.api.works.musicalstage;

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

import com.parvin.learninglists.data.works.musicalstage.Opera;
import com.parvin.learninglists.data.works.repositories.OperaRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/opera",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class OperaController {
	@Autowired
	private OperaRepository repo;

	@PostMapping
	public ResponseEntity<Opera> create(@RequestBody Opera work) {
		return ResponseEntity.ok(repo.save(work));
	}

	@GetMapping
	public ResponseEntity<Page<Opera>> getWorks(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Opera> getWorks(@PathVariable("id") Long id) {
		Optional<Opera> optionalWork = repo.findById(id);
		if (optionalWork.isPresent()) {
			return ResponseEntity.ok(optionalWork.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Opera> update(@RequestBody Opera newWork, @PathVariable Long id) {
		Opera updatedWork = repo.findById(id)
				.map(work -> {
					work.setComposer(newWork.getComposer());
					work.setTitle(newWork.getTitle());
					return repo.save(work);
				})
				.orElseGet(() -> {
					newWork.setId(id);
					return repo.save(newWork);
				});
		return ResponseEntity.ok(updatedWork);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Opera> delete(@PathVariable("id") Long id) {
		Optional<Opera> optionalWork = repo.findById(id);
		if (optionalWork.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalWork.get());
		}
	}
}
