package com.rk.employeeservice.service.impl;

import com.rk.employeeservice.dto.EmployeeDto;
import com.rk.employeeservice.entity.Employee;
import com.rk.employeeservice.exception.EmailAlreadyExistsException;
import com.rk.employeeservice.exception.ResourceNotFoundException;
import com.rk.employeeservice.respository.EmployeeRepository;
import com.rk.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
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
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.orElseThrow(
                () -> new ResourceNotFoundException("employee", "id", employeeId)
        );

        //convert Employee to EmployeeDto
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
