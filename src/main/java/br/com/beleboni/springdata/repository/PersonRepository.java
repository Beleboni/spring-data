package br.com.beleboni.springdata.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.beleboni.springdata.model.Event;
import br.com.beleboni.springdata.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

	Page<Person> findByEventId(Event eventId, Pageable pageable);
	
}