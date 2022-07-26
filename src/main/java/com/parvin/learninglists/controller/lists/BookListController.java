package com.parvin.learninglists.controller.lists;

import static com.parvin.learninglists.Constants.API_BASE;
import static com.parvin.learninglists.Constants.APPLICATION_JSON;
import static com.parvin.learninglists.Constants.DEFAULT_PAGE_NUMBER_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_PAGE_SIZE_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_SORT_BY_STRING;
import static com.parvin.learninglists.Constants.DEFAULT_SORT_DIRECTION_STRING;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.parvin.learninglists.dto.LearningListSummary;
import com.parvin.learninglists.model.lists.BookList;
import com.parvin.learninglists.model.works.Book;
import com.parvin.learninglists.service.lists.BookListService;

@RestController
@ResponseBody
@RequestMapping(path = API_BASE + "/lists/book",
				consumes = APPLICATION_JSON,
				produces = APPLICATION_JSON)
public class BookListController {
	@Autowired
	private BookListService service;
	
	@PostMapping
	public ResponseEntity<BookList> create(@RequestBody BookList list) {
		return ResponseEntity.ok(service.create(list));
	}
	
	@GetMapping
	public ResponseEntity<Page<LearningListSummary>> getLists(
			@RequestParam(name = "sort_by", defaultValue = DEFAULT_SORT_BY_STRING) String sortBy,
			@RequestParam(name = "sort_direction", defaultValue = DEFAULT_SORT_DIRECTION_STRING) String sortDirection,
			@RequestParam(name = "page_size", defaultValue = DEFAULT_PAGE_SIZE_STRING) int pageSize, 
			@RequestParam(name = "page_number", defaultValue = DEFAULT_PAGE_NUMBER_STRING) int pageNumber) {
		return ResponseEntity.ok(service.getLists(sortBy, sortDirection, pageSize, pageNumber));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookList> getList(@PathVariable("id") Long id) {
		Optional<BookList> optionalList = service.getListById(id);
		if (optionalList.isPresent()) {
			return ResponseEntity.ok(optionalList.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LearningListSummary> addToList(@RequestBody Book book, @PathVariable Long id) {
		Optional<LearningListSummary> optionalSummary = service.add(book, id);
		if (optionalSummary.isPresent()) {
			return ResponseEntity.ok(optionalSummary.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// TODO Add endpoints for adding and removing multiple books from the list.
	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<BookList> updateName(@RequestBody BookList newList, @PathVariable Long id) {
//		return ResponseEntity.ok(service.rename(newList, id));
//	} // TODO Make unique endpoint for updating the name of a list.
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<BookList> delete(@PathVariable("id") Long id) {
		Optional<BookList> list = service.getListById(id);
		if (list.isPresent()) {
			service.delete(list.get());
			return ResponseEntity.ok(list.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
