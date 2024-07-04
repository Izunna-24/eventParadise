package com.eventbooking.eventparadise.data.repositories;

import com.eventbooking.eventparadise.data.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
    Optional<Organizer> findOrganizerById(Long id);
}
