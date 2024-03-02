package com.ahnaf.firstime.student;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/api/v1/student")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping("/api/v1/student")
  public void postMethodName(@RequestBody Student student) {
    studentService.addStudent(student);
  }

}
