package com.parvin.learninglists.service.works;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.model.works.Work;

public abstract class WorkService<R extends PagingAndSortingRepository<W, Long>, W extends Work> {
	@Autowired
	private R repo;
	
	public W create(W newWork) {
		return repo.save(newWork);
	}
	
	public Optional<W> getWorkById(Long id) {
		return repo.findById(id);
	}
	
	public Page<W> getPage(Sort sort, int pageSize, int pageNumber) {
		return repo.findAll(PageRequest.of(pageSize, pageNumber, sort));
	}
	
	public void delete(W work) {
		repo.delete(work);
	}
	
	public boolean delete(Long workId) {
		Optional<W> optionalWork = repo.findById(workId);
		if (optionalWork.isPresent()) {
			repo.deleteById(workId);
			return true;
		} else {
			return false;
		}
	}
}
