package com.oshiro.employee_management.presentation.controller;

import com.oshiro.employee_management.presentation.dto.request.EmployeeCreationRequest;
import com.oshiro.employee_management.repository.EmployeeEntity;
import com.oshiro.employee_management.service.EmployeeService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@Controller
public class EmployeeManagementController {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmployeeManagementController.class);

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeEntity createEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {
        LOGGER.info("Employee creation request received: {}", employeeCreationRequest);

        return employeeService.createEmployee(employeeCreationRequest);
    }
}
