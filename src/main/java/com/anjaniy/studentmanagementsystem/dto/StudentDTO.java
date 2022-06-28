package com.anjaniy.studentmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer rollNo;
    private String name;
    private String email;
    private String departmentName;
}
