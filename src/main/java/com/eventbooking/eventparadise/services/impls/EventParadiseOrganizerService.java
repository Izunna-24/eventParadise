package com.eventbooking.eventparadise.services.impls;

import com.eventbooking.eventparadise.data.constants.Authority;
import com.eventbooking.eventparadise.data.models.Event;
import com.eventbooking.eventparadise.data.models.Organizer;
import com.eventbooking.eventparadise.data.repositories.EventRepository;
import com.eventbooking.eventparadise.data.repositories.OrganizerRepository;
import com.eventbooking.eventparadise.data.repositories.TicketRepository;
import com.eventbooking.eventparadise.dataTransferObjects.requests.*;
import com.eventbooking.eventparadise.dataTransferObjects.responses.*;
import com.eventbooking.eventparadise.exceptions.OrganizerNotFoundException;
import com.eventbooking.eventparadise.services.OrganizerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static com.eventbooking.eventparadise.data.constants.Authority.ORGANIZER;

@Service
@Slf4j
public class EventParadiseOrganizerService implements OrganizerService {

    private final OrganizerRepository organizerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;


    @Autowired
    public EventParadiseOrganizerService (OrganizerRepository organizerRepository ,
                                          ModelMapper modelMapper, PasswordEncoder passwordEncoder, EventRepository eventRepository, TicketRepository ticketRepository){
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }




    @Override
    public RegisterOrganizerResponse register(RegisterOrganizerRequest registerRequest) {
        log.info("register organizer request: {}", registerRequest);
        Organizer organizer =  modelMapper.map(registerRequest, Organizer.class);
        organizer.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        organizer.setAuthorities(new HashSet<>());
        Set<Authority> authorities = organizer.getAuthorities();
        authorities.add(ORGANIZER);
        organizer =  organizerRepository.save(organizer);
        RegisterOrganizerResponse response = modelMapper.map(organizer, RegisterOrganizerResponse.class);
        response.setMessage("registered successfully as an event organizer");
        return response;
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEvent) {
    Organizer organizer = organizerRepository
            .findOrganizerById(createEvent.getOrganizerId())
            .orElseThrow(()-> new OrganizerNotFoundException("organizer not found"));
    Event event = modelMapper.map(createEvent,Event.class);
    event.setOrganizer(organizer);
    event = eventRepository.save(event);
    CreateEventResponse eventResponse = modelMapper.map(event, CreateEventResponse.class);
    eventResponse.setMessage("event created successfully");
    return eventResponse;
    }




    @Override
    public CreateGuestListResponse getGuestList(CreateGuestListRequest createGuestList) {
        return null;
    }

    @Override
    public AddTicketResponse addTicketToEvent(AddTicketRequest addTicketRequest) {
        // Organizer organizer = organizerRepository.findOrganizerById(addTicketRequest.getOrganizerId());

//        Event event = eventRepository.findById(addTicketRequest.getEventId())
//                .orElseThrow(()-> new EventNotFoundException("event not found"));
//        Ticket ticket = modelMapper.map(addTicketRequest,Ticket.class);
//        ticket.setEvent(event);
//        ticket = ticketRepository.save(ticket);
//        AddTicketResponse response = modelMapper.map(ticket,AddTicketResponse.class);
//        response.setMessage("ticket added successfully by organizer");
//        return response;
//    }
        return null;
    }

    @Override
    public TicketDiscountResponse getDiscount(TicketDiscountRequest discountRequest) {
        return null;
    }

    @Override
    public ViewEventAttendeesResponse viewAttendees(ViewEventAttendeesRequest eventAttendeesRequest) {
        return null;
    }

    @Override
    public Organizer getByOrganizerById(long id) {
        return organizerRepository.findOrganizerById(id).orElseThrow(() -> new OrganizerNotFoundException(
                String.format("organizer with id %d not found", id)));
    }
}


