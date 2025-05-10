package com.santt4na.rapidinner.model.business;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.santt4na.rapidinner.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal amount;
  private PaymentStatus status;
  private LocalDateTime paymentDate;

  @OneToOne
  @JoinColumn(name = "order_id")
  private Order order;
}
