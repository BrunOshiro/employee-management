package com.oshiro.employeemanagement.service;

import com.oshiro.employeemanagement.presentation.dto.request.EmployeeCreationRequest;
import com.oshiro.employeemanagement.repository.EmployeeEntity;
import com.oshiro.employeemanagement.repository.EmployeeRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private static final Integer DECIMAL_SCALE = 2;

    @Transactional
    public void createEmployee(EmployeeCreationRequest employeeCreationRequest) {
        final var salary = employeeCreationRequest.salary().compareTo(BigDecimal.ZERO) < 0
                ? BigDecimal.ZERO
                : employeeCreationRequest.salary();

        employeeRepository.save(EmployeeEntity.builder()
            .name(employeeCreationRequest.name())
            .lastName(employeeCreationRequest.lastName())
            .salary(salary.setScale(DECIMAL_SCALE, RoundingMode.HALF_UP))
            .build()
        );
    }
}
