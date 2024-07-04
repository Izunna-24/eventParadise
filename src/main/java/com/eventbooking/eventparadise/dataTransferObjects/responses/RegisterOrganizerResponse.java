package com.eventbooking.eventparadise.dataTransferObjects.responses;

import com.eventbooking.eventparadise.data.constants.Authority;
import lombok.Data;

@Data
public class RegisterOrganizerResponse {
    private Long id;
    private String name;
    private String message;
    private Authority role;
}
