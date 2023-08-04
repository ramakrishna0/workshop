package com.rk.employeeservice.service;

import com.rk.employeeservice.dto.APIResponseDto;
import com.rk.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
