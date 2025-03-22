package com.santt4na.rapidinner.model.accountTypes;

import java.time.Instant;

import com.santt4na.rapidinner.enums.UserRole;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("ADMIN")
public class Admin extends User {
  private boolean active;
  private String lastLogin;

  public Admin(String name, String email, UserRole role, boolean active, String lastLogin) {
    super(name, email, role);
    this.active = active;
    this.lastLogin = lastLogin;
  }

}
