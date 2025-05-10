package com.santt4na.rapidinner.dto.businessDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.santt4na.rapidinner.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
  private BigDecimal amount;
  private PaymentStatus status;
  private LocalDateTime paymentDate;
}
