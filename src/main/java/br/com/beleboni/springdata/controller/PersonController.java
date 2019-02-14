package br.com.beleboni.springdata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beleboni.springdata.model.Event;
import br.com.beleboni.springdata.model.Person;
import br.com.beleboni.springdata.repository.EventRepository;
import br.com.beleboni.springdata.repository.PersonRepository;

@RestController
@RequestMapping("/events/{eventId}/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	public PersonController(PersonRepository personRepository, EventRepository eventRepository) {
		this.personRepository = personRepository;
		this.eventRepository = eventRepository;
	}
	
	@GetMapping
	@ResponseBody
	public Page<Person> findAll(@PathVariable("eventId") Long eventId, Pageable pageable) {
		Optional<Event> event = this.eventRepository.findById(eventId);
		
		Page<Person> people = this.personRepository.findByEventId(event.get(), pageable);
		
		return people;
//		List<Person> people = event.get().getPeople().stream().collect(Collectors.toList());
//		return people;
	}
	
	@PostMapping
	@ResponseBody
	public Person create(@PathVariable("eventId") Long eventId, @RequestBody Person person) {
		Optional<Event> event = this.eventRepository.findById(eventId);
		person.setEventId(event.get());
		return this.personRepository.save(person);
	}
	
	
	
}