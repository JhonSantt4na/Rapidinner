package com.santt4na.rapidinner.model.delivery;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressApp {

  @Column(length = 150)
  private String street;

  @Column(length = 50)
  private String city;

  @Column(length = 2)
  private String state;

  @Column(length = 10)
  private String number;

  @Column(name = "zip_code", length = 9)
  private String zipCode;

  @Column(length = 50)
  private String country;

  @Column(name = "`primary`")
  private boolean primary;
  private String complement;
  private String referencePoint;
}