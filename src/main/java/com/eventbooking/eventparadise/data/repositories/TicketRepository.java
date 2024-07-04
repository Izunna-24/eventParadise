package com.eventbooking.eventparadise.data.repositories;

import com.eventbooking.eventparadise.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
