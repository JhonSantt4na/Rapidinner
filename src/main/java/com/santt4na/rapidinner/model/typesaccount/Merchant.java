package com.santt4na.rapidinner.model.typesaccount;

import com.santt4na.rapidinner.enums.UserType;
import com.santt4na.rapidinner.model.delivery.AddressApp;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("MERCHANT")
public class Merchant extends User {
  @Column(unique = true, length = 14)
  private String cnpj;

  private String companyName;

  @Embedded
  private AddressApp businessAddress;

  public Merchant(String name, String email, UserType role, String cnpj, String companyName,
      AddressApp businessAddress) {
    super(name, email, role);
    this.cnpj = cnpj;
    this.companyName = companyName;
    this.businessAddress = businessAddress;
  }

}
