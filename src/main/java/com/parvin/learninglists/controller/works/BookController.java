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

import com.parvin.learninglists.model.works.Book;
import com.parvin.learninglists.repository.works.BookRepository;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/book",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class BookController {
	@Autowired
	private BookRepository repo;

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book) {
		return ResponseEntity.ok(repo.save(book));
	}

	@GetMapping
	public ResponseEntity<Page<Book>> getBooks(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(repo.findAll(
				PageRequest.of(pageSize, pageNumber, Sort.by(Direction.fromString(sortDirection), sortBy))));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		Optional<Book> optionalBook = repo.findById(id);
		if (optionalBook.isPresent()) {
			return ResponseEntity.ok(optionalBook.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@RequestBody Book newBook, @PathVariable Long id) {
		Book updatedBook = repo.findById(id)
				.map(book -> {
					book.setAuthor(newBook.getAuthor());
					book.setTitle(newBook.getTitle());
					return repo.save(book);
				})
				.orElseGet(() -> {
					newBook.setId(id);
					return repo.save(newBook);
				});
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Book> delete(@PathVariable("id") Long id) {
		Optional<Book> optionalBook = repo.findById(id);
		if (optionalBook.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			repo.deleteById(id);
			return ResponseEntity.ok(optionalBook.get());
		}
	}
}
