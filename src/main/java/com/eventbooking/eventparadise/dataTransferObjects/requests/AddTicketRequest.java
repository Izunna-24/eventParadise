package com.eventbooking.eventparadise.dataTransferObjects.requests;

import com.eventbooking.eventparadise.data.constants.TicketType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddTicketRequest {
    private Long eventId;
    private Long organizerId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private TicketType ticketType;

}
