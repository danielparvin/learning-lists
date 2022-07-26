package com.parvin.learninglists.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.parvin.learninglists.data.general.dtos.GeneralName;
import com.parvin.learninglists.data.lists.LearningList;
import com.parvin.learninglists.data.lists.dtos.LearningListSummary;
import com.parvin.learninglists.data.works.Work;

public abstract class ListService<
	LR extends PagingAndSortingRepository<L, Long>,
	WR extends PagingAndSortingRepository<W, Long>,
	L extends LearningList<W>,
	W extends Work> {

	@Autowired
	private LR listsRepo;
	@Autowired
	private WR worksRepo;

	public L create(L newList) {
		return listsRepo.save(newList);
	}

	public Optional<L> getListById(Long id) {
		return listsRepo.findById(id);
	}
	
	public Page<LearningListSummary> getLists(String sortBy, String sortDirection, int pageSize, int pageNumber) {
		return listsRepo.findAll(PageRequest.of(pageSize, pageNumber,
				Sort.by(Direction.fromString(sortDirection), sortBy)))
			.map(list -> {
				return new LearningListSummary(list);
			});
	}

	public L rename(L listWithNewName, Long id) {
		L updatedList = listsRepo.findById(id)
				.map(list -> {
					list.setName(list.getName());
					return listsRepo.save(list);
				})
				.orElseGet(() -> {
					listWithNewName.setId(id);
					return listsRepo.save(listWithNewName);
				});
		return updatedList;
	}

	public L rename(L list, String newName) {
		list.setName(newName);
		return listsRepo.save(list);
	}
	
	public L rename(L list, GeneralName newName) {
		list.setName(newName.getValue());
		return listsRepo.save(list);
	}
	
	public Optional<LearningListSummary> add(W work, Long listId) {
		Optional<W> optionalWork = worksRepo.findById(work.getId());
		if (optionalWork.isPresent()) {
			Optional<L> optionalList = listsRepo.findById(listId);
			if (optionalList.isPresent()) {
				L list = optionalList.get();
				list.getWorks().add(work);
				listsRepo.save(list);
				return Optional.of(new LearningListSummary(list));
			} else {
				return Optional.empty(); // TODO Clarify whether the work was not found or the list was not found.
			}
		} else {
			return Optional.empty();
		}
		
	}

	public L add(L list, W work) {
		list.getWorks().add(work);
		return listsRepo.save(list);
	}

	public L add(L list, W work, int index) {
		list.getWorks().add(index, work);
		return listsRepo.save(list);
	}

	public L remove(L list, W work) {
		list.getWorks().remove(work);
		return listsRepo.save(list);
	}

	public L remove(L list, int index) {
		list.getWorks().remove(index);
		return listsRepo.save(list);
	}
	
	public void delete(L list) {
		listsRepo.delete(list);
	}

	public boolean delete(Long listId) {
		Optional<L> optionalList = listsRepo.findById(listId);
		if (optionalList.isEmpty()) {
			return false;
		} else {
			listsRepo.deleteById(listId);
			return true;
		}
	}
}
