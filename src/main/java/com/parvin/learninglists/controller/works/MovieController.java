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

import com.parvin.learninglists.model.works.Movie;
import com.parvin.learninglists.repository.works.MovieRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/movie",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class MovieController {
	@Autowired
	private MovieRepository movieRepo;

	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieRepo.save(movie));
	}

	@GetMapping
	public ResponseEntity<Page<Movie>> getMovies(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(movieRepo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
		Optional<Movie> optionalMovie = movieRepo.findById(id);
		if (optionalMovie.isPresent()) {
			return ResponseEntity.ok(optionalMovie.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Movie> update(@RequestBody Movie newMovie, @PathVariable Long id) {
		Movie updatedMovie = movieRepo.findById(id)
				.map(movie -> {
					movie.setTitle(newMovie.getTitle());
					movie.setDirector(newMovie.getDirector());
					movie.setActors(newMovie.getActors());
					movie.setReleasedOn(newMovie.getReleasedOn());
					return movieRepo.save(movie);
				})
				.orElseGet(() -> {
					newMovie.setId(id);
					return movieRepo.save(newMovie);
				});
		return ResponseEntity.ok(updatedMovie);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Movie> delete(@PathVariable("id") Long id) {
		Optional<Movie> optionalMovie = movieRepo.findById(id);
		if (optionalMovie.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			movieRepo.deleteById(id);
			return ResponseEntity.ok(optionalMovie.get());
		}
	}
}
