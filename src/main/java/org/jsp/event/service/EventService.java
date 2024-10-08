package org.jsp.event.service;

import java.util.List;
import java.util.Optional;

import org.jsp.event.dao.EventDao;
import org.jsp.event.entity.Events;
import org.jsp.event.reponseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventService 
{
	@Autowired
	EventDao dao;

	public ResponseStructure<Events> saveEvents(Events event) 
	{
		Events e = dao.saveEvents(event);
		ResponseStructure<Events> structure = new ResponseStructure<>();
		structure.setStatus(201);
		structure.setMessage("Event created successfully...");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<List<Events>> getAllEvents() {
		List<Events> e = dao.getAllEvents();
		ResponseStructure<List<Events>> structure = new ResponseStructure<>();
		if(e.isEmpty())
		{
			structure.setStatus(404);
			structure.setMessage("No Events found...");
			structure.setBody(null);
			return structure;
		}
		structure.setStatus(200);
		structure.setMessage("Events found successfully...");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<Events> getEventBrId(int id) 
	{
		Optional<Events> optional = dao.getEventBrId(id);
		ResponseStructure<Events> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			structure.setStatus(404);
			structure.setMessage("No Events found...");
			structure.setBody(null);
			return structure;
		}
		Events e = optional.get();
		structure.setStatus(200);
		structure.setMessage("Events found successfully...");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<String> deleteEventById(int id) 
	{
		Optional<Events> optional = dao.getEventBrId(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if(optional.isEmpty())
		{
			structure.setStatus(404);
			structure.setMessage("No Events found...");
			structure.setBody(null);
			return structure;
		}
		dao.deleteEventById(id);
		structure.setStatus(200);
		structure.setMessage("Events deleted successfully...");
		structure.setBody("Event deleted...");
		return structure;
	}

	public ResponseStructure<Events> updateEvent(Events event) 
	{
		Events e = dao.updateEvent(event);
		ResponseStructure<Events> structure = new ResponseStructure<>();
		structure.setStatus(201);
		structure.setMessage("Event updated successfully...");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<List<Events>> getEventByTitle(String title) 
	{
		List<Events> e = dao.getEventByTitle(title);
		ResponseStructure<List<Events>> structure = new ResponseStructure<>();
		if(e.isEmpty())
		{
			structure.setStatus(404);
			structure.setMessage("No Events found...");
			structure.setBody(null);
			return structure;
		}
		structure.setStatus(200);
		structure.setMessage("Events found successfully...");
		structure.setBody(e);
		return structure;
	}

}
