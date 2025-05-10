package com.santt4na.rapidinner.dto.typesaccountDto;

import com.santt4na.rapidinner.model.delivery.AddressApp;

import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("MERCHANT")
public class MerchantDto extends UserDto {
  private Long id;
  private String cnpj;
  private AddressApp businessAddress;
  private String companyName;
}
