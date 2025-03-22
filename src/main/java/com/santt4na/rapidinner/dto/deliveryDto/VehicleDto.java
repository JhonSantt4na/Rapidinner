package com.santt4na.rapidinner.dto.deliveryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

        @NotBlank(message = "Vehicle type is required")
        private String vehicleType;

        @NotBlank(message = "Color is required")
        private String color;

        @NotBlank(message = "Model is required")
        private String model;

        @NotBlank(message = "License plate is required")
        @Pattern(regexp = "^[A-Z]{3}-?\\d[A-Z]\\d{2}$", message = "Invalid license plate format. Use AAA-1B34 or AAA1B34")
        private String plate;
}