package com.eventbooking.eventparadise.data.repositories;

import com.eventbooking.eventparadise.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findById(long id);
}
