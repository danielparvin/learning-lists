package com.parvin.learninglists.api.works;

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

import com.parvin.learninglists.data.works.VisualArtwork;
import com.parvin.learninglists.data.works.repositories.VisualArtworkRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/visual-artwork",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class VisualArtworkController {
	@Autowired
	private VisualArtworkRepository repo;

	@PostMapping
	public ResponseEntity<VisualArtwork> create(@RequestBody VisualArtwork visualArtwork) {
		return ResponseEntity.ok(repo.save(visualArtwork));
	}

	@GetMapping
	public ResponseEntity<Page<VisualArtwork>> getVisualArtworks(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VisualArtwork> getVisualArtwork(@PathVariable("id") Long id) {
		Optional<VisualArtwork> optionalVisualArtwork = repo.findById(id);
		if (optionalVisualArtwork.isPresent()) {
			return ResponseEntity.ok(optionalVisualArtwork.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<VisualArtwork> update(@RequestBody VisualArtwork newVisualArtwork, @PathVariable Long id) {
		VisualArtwork updatedVisualArtwork = repo.findById(id)
				.map(visualArtwork -> {
					visualArtwork.setTitle(newVisualArtwork.getTitle());
					visualArtwork.setArtist(newVisualArtwork.getArtist());
					return repo.save(visualArtwork);
				})
				.orElseGet(() -> {
					newVisualArtwork.setId(id);
					return repo.save(newVisualArtwork);
				});
		return ResponseEntity.ok(updatedVisualArtwork);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<VisualArtwork> delete(@PathVariable("id") Long id) {
		Optional<VisualArtwork> optionalVisualArtwork = repo.findById(id);
		if (optionalVisualArtwork.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalVisualArtwork.get());
		}
	}
}
