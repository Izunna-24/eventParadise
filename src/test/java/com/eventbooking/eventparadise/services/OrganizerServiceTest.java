package com.eventbooking.eventparadise.services;


import com.eventbooking.eventparadise.data.models.Organizer;
import com.eventbooking.eventparadise.data.repositories.OrganizerRepository;
import com.eventbooking.eventparadise.dataTransferObjects.requests.CreateEventRequest;
import com.eventbooking.eventparadise.dataTransferObjects.requests.RegisterOrganizerRequest;
import com.eventbooking.eventparadise.dataTransferObjects.responses.RegisterOrganizerResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static com.eventbooking.eventparadise.data.constants.EventCategory.CONFERENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/data.sql"})
public class OrganizerServiceTest {

    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private OrganizerRepository organizerRepository;

    @Test
    @DisplayName("test that event organizer can be registered")
    public void registerOrganizerTest() {
        RegisterOrganizerRequest request = new RegisterOrganizerRequest();
        request.setName("Lanre Makun");
        request.setEmail("email@gmail.com");
        request.setPassword("password");


        RegisterOrganizerResponse response = organizerService.register(request);
        assertNotNull(response);
        assertTrue(response.getMessage().contains("success"));
    }

    @Test
    @DisplayName("test that organizer can create event")
    public void organizerCanCreateEventTest(){
        Organizer organizer = organizerService.getByOrganizerById(400L);
        CreateEventRequest createEvent = new CreateEventRequest();
        createEvent.setOrganizerId(organizer.getId());
        createEvent.setCategory(CONFERENCE);
        createEvent.setDescription("frenzy gathering of strangers");
        createEvent.setName("Tamerri festival");
        var event =  organizerService.createEvent(createEvent);
        assertNotNull(event);

        assertThat(CONFERENCE).isEqualTo(event.getCategory());
        assertThat("Tamerri festival").isEqualTo(event.getName());

    }
}
