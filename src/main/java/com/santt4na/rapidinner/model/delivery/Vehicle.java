package com.santt4na.rapidinner.model.delivery;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
  private String vehicleType;
  private String color;
  private String model;
  private String plate;
}
