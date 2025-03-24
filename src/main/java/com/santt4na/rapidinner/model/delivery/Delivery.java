package com.santt4na.rapidinner.model.delivery;

import com.santt4na.rapidinner.enums.StatsDelivery;
import com.santt4na.rapidinner.model.typesaccount.Customer;
import com.santt4na.rapidinner.model.typesaccount.DeliveryMan;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
  private AddressApp localEntrega;
  private StatsDelivery statsDelivery;
  private Customer Customer;

  @OneToOne
  private DeliveryMan deliveryMan;
}
