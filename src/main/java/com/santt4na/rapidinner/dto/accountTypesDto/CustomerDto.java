package com.santt4na.rapidinner.dto.accountTypesDto;

import java.util.HashMap;
import java.util.Map;

import com.santt4na.rapidinner.dto.deliveryDto.AddressDto;
import com.santt4na.rapidinner.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CustomerDto extends UserDto {
  private String cpf;
  private Map<AddressType, AddressDto> addresses = new HashMap<>();
}
