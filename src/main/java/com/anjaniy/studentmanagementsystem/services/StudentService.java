package com.anjaniy.studentmanagementsystem.services;

import com.anjaniy.studentmanagementsystem.dto.StudentDto;
import com.anjaniy.studentmanagementsystem.models.Student;
import com.anjaniy.studentmanagementsystem.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudentDto getStudentByRollNo(Integer rollNo) {
        return modelMapper.map(studentRepository.findById(rollNo).get(), StudentDto.class);
    }

    @Transactional
    public StudentDto addStudent(StudentDto studentDTO) {
        Student addedStudent = studentRepository.save(modelMapper.map(studentDTO, Student.class));
        studentDTO.setRollNo(addedStudent.getRollNo());
        return studentDTO;
    }

    @Transactional
    public void deleteStudent(Integer rollNo) {
        studentRepository.deleteById(rollNo);
    }

    @Transactional
    public StudentDto updateStudent(StudentDto studentDTO) {
        Student updatedStudent = studentRepository.save(modelMapper.map(studentDTO, Student.class));
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Transactional
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
