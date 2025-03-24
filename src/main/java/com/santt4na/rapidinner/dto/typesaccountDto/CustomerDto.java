package com.santt4na.rapidinner.dto.typesaccountDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.santt4na.rapidinner.dto.businessDto.OrderDto;
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
  private List<OrderDto> orders = new ArrayList<>();
}
