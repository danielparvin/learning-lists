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

import com.parvin.learninglists.data.works.musicalstage.Ballet;
import com.parvin.learninglists.data.works.repositories.BalletRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/ballet",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class BalletController {
	@Autowired
	private BalletRepository repo;

	@PostMapping
	public ResponseEntity<Ballet> create(@RequestBody Ballet work) {
		return ResponseEntity.ok(repo.save(work));
	}

	@GetMapping
	public ResponseEntity<Page<Ballet>> getWorks(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ballet> getWorks(@PathVariable("id") Long id) {
		Optional<Ballet> optionalWork = repo.findById(id);
		if (optionalWork.isPresent()) {
			return ResponseEntity.ok(optionalWork.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Ballet> update(@RequestBody Ballet newWork, @PathVariable Long id) {
		Ballet updatedWork = repo.findById(id)
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
	public ResponseEntity<Ballet> delete(@PathVariable("id") Long id) {
		Optional<Ballet> optionalWork = repo.findById(id);
		if (optionalWork.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalWork.get());
		}
	}
}
