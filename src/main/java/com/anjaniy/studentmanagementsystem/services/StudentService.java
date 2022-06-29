package com.anjaniy.studentmanagementsystem.services;

import com.anjaniy.studentmanagementsystem.dto.StudentDTO;
import com.anjaniy.studentmanagementsystem.models.Student;
import com.anjaniy.studentmanagementsystem.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentDTO getStudentByRollNo(Integer rollNo) {
        return modelMapper.map(studentRepository.findById(rollNo).get(), StudentDTO.class);
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student addedStudent = studentRepository.save(modelMapper.map(studentDTO, Student.class));
        studentDTO.setRollNo(addedStudent.getRollNo());
        return studentDTO;
    }

    public void deleteStudent(Integer rollNo) {
        studentRepository.deleteById(rollNo);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student updatedStudent = studentRepository.save(modelMapper.map(studentDTO, Student.class));
        return modelMapper.map(updatedStudent, StudentDTO.class);
    }
}
