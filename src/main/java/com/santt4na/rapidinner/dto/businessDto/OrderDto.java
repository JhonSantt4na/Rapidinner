package com.santt4na.rapidinner.dto.businessDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.santt4na.rapidinner.dto.typesaccountDto.CustomerDto;
import com.santt4na.rapidinner.dto.typesaccountDto.DeliveryManDto;
import com.santt4na.rapidinner.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
  private Long id;
  private List<OrderItemsDto> items = new ArrayList<>();
  private StatusOrder statusOrder;
  private LocalDateTime dateTime;
  private BigDecimal totalValue;
  private CustomerDto customer;
  private DeliveryManDto deliveryman;
  private PaymentDto payment;

}
