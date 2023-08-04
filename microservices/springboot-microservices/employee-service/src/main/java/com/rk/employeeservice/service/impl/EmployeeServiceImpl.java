package com.rk.employeeservice.service.impl;

import com.rk.departmentservice.dto.DepartmentDTO;
import com.rk.employeeservice.dto.APIResponseDto;
import com.rk.employeeservice.dto.EmployeeDto;
import com.rk.employeeservice.entity.Employee;
import com.rk.employeeservice.exception.EmailAlreadyExistsException;
import com.rk.employeeservice.exception.ResourceNotFoundException;
import com.rk.employeeservice.respository.EmployeeRepository;
import com.rk.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.module.ResolutionException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert EmployeeDto to Employee
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        // check if email already exists
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists for Employee");
        }

        Employee savedEmployee = employeeRepository.save(employee);

        //convert Employee to EmployeeDto
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.orElseThrow(
                () -> new ResourceNotFoundException("employee", "id", employeeId)
        );
        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDTO.class
        );
        DepartmentDTO departmentDTO = responseEntity.getBody();

        //convert Employee to EmployeeDto
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return new APIResponseDto(employeeDto, departmentDTO);
    }
}
