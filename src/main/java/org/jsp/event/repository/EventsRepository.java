package org.jsp.event.repository;

import java.util.List;

import org.jsp.event.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Integer>{

	List<Events> getEventByTitle(String title);

}
