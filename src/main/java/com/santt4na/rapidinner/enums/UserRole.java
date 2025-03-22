package com.santt4na.rapidinner.enums;

public enum UserRole {
  ROLE_CUSTOMER("Customer"),
  ROLE_DELIVERYMAN("Deliveryman"),
  ROLE_MERCHANT("Merchant"),
  ROLE_ADMIN("Admin");

  private final String description;

  UserRole(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public static UserRole fromString(String role) {
    return UserRole.valueOf(role.toUpperCase());
  }
}
