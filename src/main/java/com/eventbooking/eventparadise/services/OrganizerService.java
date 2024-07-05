package com.eventbooking.eventparadise.services;

import com.eventbooking.eventparadise.data.models.Organizer;
import com.eventbooking.eventparadise.dataTransferObjects.requests.*;
import com.eventbooking.eventparadise.dataTransferObjects.responses.*;

public interface OrganizerService {
RegisterOrganizerResponse register(RegisterOrganizerRequest registerRequest);
CreateEventResponse createEvent(CreateEventRequest createEvent);
CreateGuestListResponse getGuestList(CreateGuestListRequest createGuestList);
AddTicketResponse addTicketToEvent(AddTicketRequest addTicketRequest);
TicketDiscountResponse getDiscount(TicketDiscountRequest discountRequest);
ViewEventAttendeesResponse viewAttendees(ViewEventAttendeesRequest eventAttendeesRequest);
Organizer getByOrganizerById(long id);
}
