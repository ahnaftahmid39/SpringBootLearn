package com.ahnaf.firstime.student;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(value = { "", "/" })
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping(value = { "", "/" })
  public void postMethodName(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @DeleteMapping(value = "/{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  @PutMapping(value = "/{studentId}")
  public void updateStudent(
      @PathVariable("studentId") Long studentId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    studentService.updateStudent(studentId, name, email);
  }

}
