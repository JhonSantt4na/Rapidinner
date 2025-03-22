package com.santt4na.rapidinner.model.accountTypes;

import java.util.HashMap;
import java.util.Map;

import com.santt4na.rapidinner.enums.AddressType;
import com.santt4na.rapidinner.enums.UserType;
import com.santt4na.rapidinner.model.delivery.AddressApp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Customer")
public class Customer extends User {

  @Column(unique = true)
  private String cpf;

  @ElementCollection
  @CollectionTable(name = "customer_addresses", joinColumns = @JoinColumn(name = "customer_id"))
  @MapKeyEnumerated(EnumType.STRING)
  @MapKeyColumn(name = "address_type")
  private Map<AddressType, AddressApp> addresses = new HashMap<>();

  public Customer(String name, String email, UserType role, String cpf) {
    super(name, email, role);
    this.cpf = cpf;
  }

  public void addAddress(AddressType type, AddressApp address) {
    addresses.put(type, address);
  }

  public void removeAddress(AddressType type) {
    addresses.remove(type);
  }
}
