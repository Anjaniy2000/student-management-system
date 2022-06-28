package com.anjaniy.studentmanagementsystem.controllers;

import com.anjaniy.studentmanagementsystem.dto.StudentDTO;
import com.anjaniy.studentmanagementsystem.models.Student;
import com.anjaniy.studentmanagementsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
        return status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));
    }

    @PostMapping("/deleteStudent/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("rollNo") Integer rollNo){
        studentService.deleteStudent(rollNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
