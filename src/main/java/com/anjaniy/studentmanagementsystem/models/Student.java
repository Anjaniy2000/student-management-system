package com.anjaniy.studentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roll_no")
    private Integer rollNo;

    @Column(name = "student_name")
    @NotBlank(message = "Student Name Is Required")
    @Size(max = 30, message = "Student Name Must Be Between 0 To 30")
    private String name;

    @Column(name = "student_email")
    @NotBlank(message = "Student Email Address Is Required")
    @Email(message = "Student Email Address Is Not A Valid Email Address")
    private String email;

    @Column(name = "student_department_name")
    @NotBlank(message = "Student Department Name Is Required")
    @Size(max = 30, message = "Department Name Must Be Between 0 To 30")
    private String departmentName;

}
