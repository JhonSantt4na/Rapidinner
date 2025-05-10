package com.santt4na.rapidinner.dto.deliveryDto;

import com.santt4na.rapidinner.dto.typesaccountDto.CustomerDto;
import com.santt4na.rapidinner.dto.typesaccountDto.DeliveryManDto;
import com.santt4na.rapidinner.enums.StatsDelivery;
import com.santt4na.rapidinner.model.delivery.AddressApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
  private AddressApp localEntrega;
  private StatsDelivery statsDelivery;
  private CustomerDto Customer;
  private DeliveryManDto deliveryMan;
}
