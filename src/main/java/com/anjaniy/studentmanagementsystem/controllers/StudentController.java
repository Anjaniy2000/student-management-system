package com.anjaniy.studentmanagementsystem.controllers;

import com.anjaniy.studentmanagementsystem.dto.StudentDTO;
import com.anjaniy.studentmanagementsystem.models.Student;
import com.anjaniy.studentmanagementsystem.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/getStudentByRollNo/{rollNo}")
    public ResponseEntity<StudentDTO> getStudentByRollNo(@Valid @PathVariable("rollNo") Integer rollNo){
        return status(HttpStatus.OK).body(studentService.getStudentByRollNo(rollNo));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentDTO studentDTO){
        return status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));
    }

    @DeleteMapping("/deleteStudent/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@Valid @PathVariable("rollNo") Integer rollNo){
        studentService.deleteStudent(rollNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<Void> deleteAllStudents(){
        studentService.deleteAllStudents();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO studentDTO){
        return status(HttpStatus.OK).body(studentService.updateStudent(studentDTO));
    }

}
