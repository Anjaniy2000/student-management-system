package com.anjaniy.studentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roll_no")
    private Integer rollNo;

    @Column(name = "student_name")
    @NotBlank(message = "Student Name Is Required")
    private String name;

    @Column(name = "student_email")
    @Email
    @NotBlank(message = "Student Email Address Is Required")
    private String email;

    @Column(name = "student_department_name")
    @NotBlank(message = "Student Department Name Is Required")
    private String departmentName;

}
