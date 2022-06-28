package com.parvin.learninglists.api.lists;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parvin.learninglists.data.lists.BookList;
import com.parvin.learninglists.data.lists.repositories.BookListRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/lists/book",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class BookListController {
	@Autowired
	private BookListRepository repo;
	
	@PostMapping
	public ResponseEntity<BookList> create(@RequestBody BookList list) {
		return ResponseEntity.ok(repo.save(list));
	}
	
	@GetMapping
	public ResponseEntity<Page<BookList>> getLists(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookList> getList(@PathVariable("id") Long id) {
		Optional<BookList> optionalList = repo.findById(id);
		if (optionalList.isPresent()) {
			return ResponseEntity.ok(optionalList.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// TODO Add endpoints for adding and removing individual and multiple books from the list.
	// TODO Add endpoint for updating the name of the list.
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BookList> delete(@PathVariable("id") Long id) {
		Optional<BookList> optionalList = repo.findById(id);
		if (optionalList.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalList.get());
		}
	}
}
