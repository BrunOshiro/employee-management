package com.oshiro.employeemanagement.presentation.controller;

import com.oshiro.employeemanagement.presentation.dto.request.EmployeeCreationRequest;
import com.oshiro.employeemanagement.repository.EmployeeEntity;
import com.oshiro.employeemanagement.service.EmployeeService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EmployeeManagementController {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmployeeManagementController.class);

    private final EmployeeService employeeService;

    public EmployeeManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {
        employeeService.createEmployee(employeeCreationRequest);
        LOGGER.info("Employee creation request received: {}", employeeCreationRequest);
    }
}
