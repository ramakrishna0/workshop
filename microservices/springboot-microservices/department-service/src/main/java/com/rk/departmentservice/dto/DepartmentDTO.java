package com.rk.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDTO model information"
)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    @Schema(description = "Department Name")
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
