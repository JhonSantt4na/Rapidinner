package com.santt4na.rapidinner.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
  ROLE_ADMIN("Admin"),
  ROLE_CUSTOMER("Customer"),
  ROLE_DELIVERYMAN("Deliveryman"),
  ROLE_MERCHANT("Merchant");

  private final String value;
  private static final Map<String, UserType> UserMap = new HashMap<>();

  UserType(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static UserType fromString(String role) {
    return UserType.valueOf(role.toUpperCase());
  }

  static {
    for (UserType role : values()) {
      UserMap.put(role.getValue(), role);
    }
  }

  // Converte uma String (ex: "Admin") para o Enum correspondente
  public static UserType formValue(String value) {
    UserType role = UserMap.get(value.toUpperCase());
    if (role == null) {
      throw new IllegalArgumentException("Invalid role: " + role);
    }
    return role;
  }

}