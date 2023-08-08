package com.rk.departmentservice.service.impl;

import com.rk.departmentservice.dto.DepartmentDTO;
import com.rk.departmentservice.entity.Department;
import com.rk.departmentservice.exception.ResourceNotFoundException;
import com.rk.departmentservice.repository.DepartmentRepository;
import com.rk.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        //convert DepartmentDTO to DepartmentDTO
        Department department = modelMapper.map(departmentDTO, Department.class);

        Department savedDepartment = departmentRepository.save(department);

        //convert Department to Department DTO

        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(departmentCode);
        Department department = optionalDepartment.orElseThrow(
                () -> new ResourceNotFoundException("department", "code", departmentCode)
        );

        //convert Department to DepartmentDTO
        return modelMapper.map(department, DepartmentDTO.class);
    }
}
