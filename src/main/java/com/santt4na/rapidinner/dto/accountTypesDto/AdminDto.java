package com.santt4na.rapidinner.dto.accountTypesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto extends UserDto {
  private boolean active;
  private String lastLogin;
}
