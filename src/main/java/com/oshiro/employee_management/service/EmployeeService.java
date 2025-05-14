package com.oshiro.employee_management.service;

import com.oshiro.employee_management.presentation.dto.request.EmployeeCreationRequest;
import com.oshiro.employee_management.repository.EmployeeEntity;
import com.oshiro.employee_management.repository.EmployeeRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeEntity createEmployee(EmployeeCreationRequest employeeCreationRequest) {
        final var employeeEntity = EmployeeEntity.builder()
                .name(employeeCreationRequest.name())
                .lastName(employeeCreationRequest.lastName())
                .salary(employeeCreationRequest.salary())
                .build();

        employeeRepository.save(employeeEntity);

        return employeeEntity;
    }
}
