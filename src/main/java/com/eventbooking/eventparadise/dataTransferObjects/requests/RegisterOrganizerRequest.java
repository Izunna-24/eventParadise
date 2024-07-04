package com.eventbooking.eventparadise.dataTransferObjects.requests;

import lombok.Data;

@Data
public class RegisterOrganizerRequest {
  private String name;
  private String email;
  private String password;
}
