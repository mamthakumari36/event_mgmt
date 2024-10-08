package org.jsp.event.contoller;

import java.util.List;

import org.jsp.event.entity.Events;
import org.jsp.event.reponseStructure.ResponseStructure;
import org.jsp.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController 
{
	@Autowired
	EventService service;
	
	@PostMapping("/event")
	public ResponseStructure<Events> saveEvents(@RequestBody Events event)
	{
		return service.saveEvents(event);
	}
	
	@GetMapping("/event")
	public ResponseStructure<List<Events>> getAllEvents()
	{
		return service.getAllEvents();
	}
	
	@GetMapping("/event/{id}")
	public ResponseStructure<Events> getEventBrId(@PathVariable int id)
	{
		return service.getEventBrId(id);
	}
	
	@DeleteMapping("/event/{id}")
	public ResponseStructure<String> deleteEventById(@PathVariable int id)
	{
		return service.deleteEventById(id);
	}
	
	@PutMapping("/event")
	public ResponseStructure<Events> updateEvent(@RequestBody Events event)
	{
		return service.updateEvent(event);
	}
	
	@GetMapping("/event/title/{title}")
	public ResponseStructure<List<Events>> getEventByTitle(@PathVariable String title)
	{
		return service.getEventByTitle(title);
	}
}
