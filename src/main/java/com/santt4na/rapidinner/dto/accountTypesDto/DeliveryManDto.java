package com.santt4na.rapidinner.dto.accountTypesDto;

import java.math.BigDecimal;

import com.santt4na.rapidinner.model.delivery.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryManDto extends UserDto {
  private BigDecimal rating;
  private String cnh;
  private boolean available;
  private Vehicle vehicle;
}
