package com.santt4na.rapidinner.model.business;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.santt4na.rapidinner.enums.StatusOrder;
import com.santt4na.rapidinner.model.typesaccount.Customer;
import com.santt4na.rapidinner.model.typesaccount.DeliveryMan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private StatusOrder statusOrder;

  // Relacionamento com Customer
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  // Relacionamento com Deliveryman
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deliveryman_id")
  private DeliveryMan deliveryman;

  // Relacionamento com Payment
  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;

  private LocalDateTime dateTime;
  private BigDecimal totalValue;

}
