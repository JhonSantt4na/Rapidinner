package com.santt4na.rapidinner.dto.deliveryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
  @NotBlank(message = "Street cannot be blank")
  private String street;

  @NotBlank(message = "City cannot be blank")
  private String city;

  @NotBlank(message = "State cannot be blank")
  @Size(min = 2, max = 2, message = "State must be 2 characters")
  private String state;

  @NotBlank(message = "Number cannot be blank")
  @Pattern(regexp = "^\\d+[A-Za-z]?$", message = "Invalid format. Valid examples: 123, 456B")
  private String number;

  @NotBlank(message = "ZIP code cannot be blank")
  @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Invalid format. Use XXXXX-XXX")
  private String zipCode;

  @NotBlank(message = "Country cannot be blank")
  private String country;

  private boolean primary;
  private String complement;
  private String referencePoint;
}