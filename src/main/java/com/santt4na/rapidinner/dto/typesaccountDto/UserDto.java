package com.santt4na.rapidinner.dto.typesaccountDto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.santt4na.rapidinner.enums.UserType;

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
  private Long id;
  private String name;
  private String email;
  private UserType role;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
