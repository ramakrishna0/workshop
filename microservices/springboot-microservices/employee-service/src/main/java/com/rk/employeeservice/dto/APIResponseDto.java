package com.rk.employeeservice.dto;

import com.example.organizationservice.dto.OrganizationDto;
import com.rk.departmentservice.dto.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDTO departmentDTO;
    private OrganizationDto organizationDto;
}
