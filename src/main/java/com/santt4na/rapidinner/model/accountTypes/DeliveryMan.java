package com.santt4na.rapidinner.model.accountTypes;

import java.math.BigDecimal;

import com.santt4na.rapidinner.enums.UserRole;
import com.santt4na.rapidinner.model.delivery.Vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("DELIVERY_MAN")
public class DeliveryMan extends User {

  @DecimalMin("0.0")
  @DecimalMax("5.0")
  @Column(precision = 3, scale = 2)
  private BigDecimal rating;

  private String cnh;

  private boolean available;

  @Embedded
  private Vehicle vehicle;

  public DeliveryMan(String name, String email, UserRole role, @DecimalMin("0.0") @DecimalMax("5.0") BigDecimal rating,
      String cnh, boolean available, Vehicle vehicle) {
    super(name, email, role);
    this.rating = rating;
    this.cnh = cnh;
    this.available = available;
    this.vehicle = vehicle;
  }

}
