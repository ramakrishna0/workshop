package com.rk.departmentservice.repository;

import com.rk.departmentservice.dto.DepartmentDTO;
import com.rk.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentCode(String code);
}
