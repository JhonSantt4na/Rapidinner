package com.santt4na.rapidinner.dto.businessDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

  private List<OrderItemsDto> orderItems = new ArrayList<>();
  private String name;
  private String description;
  private BigDecimal price;
  private Integer stock;

}
