package com.oshiro.employeemanagement.presentation.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record EmployeeCreationRequest(

        @NotBlank(message = "Name cannot be blank")
        @NotNull(message = "Name cannot be null")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotBlank(message = "Last name cannot be blank")
        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String lastName,

        @NotNull(message = "Salary cannot be null")
        @DecimalMin(value = "1000", message = "Salary must be greater than 1000")
        @DecimalMax(value = "1000000", message = "Salary must be less than 1000000")
        BigDecimal salary
) {
}
