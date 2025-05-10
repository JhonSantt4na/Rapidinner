package com.santt4na.rapidinner.enums;

import java.util.HashMap;
import java.util.Map;

public enum VehicleTypeEnum {
  MOTORCYCLE("Motorcycle"),
  CAR("Car"),
  BICYCLE("Bicycle");

  private final String value;
  private static final Map<String, VehicleTypeEnum> vehicleType = new HashMap<>();

  VehicleTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static VehicleTypeEnum fromString(String role) {
    return VehicleTypeEnum.valueOf(role.toUpperCase());
  }

  static {
    for (VehicleTypeEnum vehicle : VehicleTypeEnum.values()) {
      vehicleType.put(vehicle.getValue(), vehicle);
    }
  }

  // Converte uma String (ex: "Admin") para o Enum correspondente
  public static VehicleTypeEnum formValue(String value) {
    VehicleTypeEnum role = vehicleType.get(value.toUpperCase());
    if (role == null) {
      throw new IllegalArgumentException("Invalid role: " + role);
    }
    return role;
  }
}
