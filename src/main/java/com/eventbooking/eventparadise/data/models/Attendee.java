package com.eventbooking.eventparadise.data.models;

import com.eventbooking.eventparadise.data.constants.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "attendees")
public class Attendee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    private String email;
    @ElementCollection
    @Enumerated(STRING)
    private Set<Authority> authorities;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
