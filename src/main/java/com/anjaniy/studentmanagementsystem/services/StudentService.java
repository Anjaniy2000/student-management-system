package com.anjaniy.studentmanagementsystem.services;

import com.anjaniy.studentmanagementsystem.dto.StudentDTO;
import com.anjaniy.studentmanagementsystem.models.Student;
import com.anjaniy.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = studentRepository.save(mapToEntity(studentDTO));
        studentDTO.setRollNo(student.getRollNo());
        return studentDTO;
    }

    private Student mapToEntity(StudentDTO studentDTO){
        return Student.builder().name(studentDTO.getName()).email(studentDTO.getEmail()).departmentName(studentDTO.getDepartmentName()).build();
    }

    public void deleteStudent(Integer rollNo) {
        studentRepository.deleteById(rollNo);
    }
}
