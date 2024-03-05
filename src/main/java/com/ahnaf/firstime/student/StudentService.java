package com.ahnaf.firstime.student;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
    
  }

  public void addStudent(Student student) {
    if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {

      throw new IllegalStateException("Email already taken");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (exists) {
      studentRepository.deleteById(studentId);
    } else {
      throw new IllegalStateException("Student with id " + studentId + " does not exist");
    }
  }

  @Transactional
  public void updateStudent(Long studentId, String name, String email) {
    Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    } 
    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
      if (studentRepository.findStudentByEmail(email).isPresent()) {
        throw new IllegalStateException("Email already taken");
      }
      student.setEmail(email);
    }
    
  }
}
