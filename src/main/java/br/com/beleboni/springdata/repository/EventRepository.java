package br.com.beleboni.springdata.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.beleboni.springdata.model.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
