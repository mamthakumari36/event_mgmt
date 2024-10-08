package org.jsp.event.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.event.entity.Events;
import org.jsp.event.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDao 
{
	@Autowired
	EventsRepository repository;

	public Events saveEvents(Events event) 
	{
		return repository.save(event);
		
	}

	public List<Events> getAllEvents() {
		
		return repository.findAll();
	}

	public Optional<Events> getEventBrId(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public void deleteEventById(int id) {
		repository.deleteById(id);
		
	}

	public Events updateEvent(Events event) {
		// TODO Auto-generated method stub
		return repository.save(event);
	}

	public List<Events> getEventByTitle(String title) {
		
		return repository.getEventByTitle(title);
	}
	
	

}
