package com.santt4na.rapidinner.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {
  PENDING("Pending"), // Pendente
  SUCCESS("Success"), // Sucesso
  FAILED("Failed"), // Falha
  FULLY_REFUNDED("Fully Refunded"), // Reembolsado totalmente
  ABANDONED("Abandoned"), // Abandonado
  EXPIRED("Expired"), // Expirado
  UNDER_REVIEW("Under Review"), // Em analise
  CANCELLED("Cancelled"); // Cancelado

  private final String value;

  PaymentStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static PaymentStatus fromValue(String value) {
    for (PaymentStatus status : values()) {
      if (status.value.equalsIgnoreCase(value)) {
        return status;
      }
    }
    throw new IllegalArgumentException("Status de pagamento inválido: " + value);
  }

  @Override
  public String toString() {
    return this.value;
  }
}
