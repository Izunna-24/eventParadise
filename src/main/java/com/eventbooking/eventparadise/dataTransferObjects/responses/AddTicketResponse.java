package com.eventbooking.eventparadise.dataTransferObjects.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTicketResponse {
    private Long ticketId;
    private String message;
}
