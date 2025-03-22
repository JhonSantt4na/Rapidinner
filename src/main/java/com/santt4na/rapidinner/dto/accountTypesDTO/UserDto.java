package com.santt4na.rapidinner.dto.accountTypesDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.santt4na.rapidinner.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AdminDto.class, name = "ADMIN"),
    @JsonSubTypes.Type(value = DeliveryManDto.class, name = "DELIVERYMAN")
})
public abstract class UserDto {
  private String name;
  private String email;
  private UserRole role;
}
