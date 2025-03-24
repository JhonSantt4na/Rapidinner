package com.santt4na.rapidinner.model.business.Key;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderProductKey implements Serializable {
  private Long orderId;
  private Long productId;
}
