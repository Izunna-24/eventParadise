package com.eventbooking.eventparadise.dataTransferObjects.responses;


import com.eventbooking.eventparadise.data.constants.EventCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEventResponse {
    private String id;
    private String name;
    @JsonProperty("event_description")
    private String description;
    @JsonProperty("event_category")
    private EventCategory category;
    private String message;


}
