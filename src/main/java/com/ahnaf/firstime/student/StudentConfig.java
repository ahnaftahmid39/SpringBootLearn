package com.ahnaf.firstime.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
    return args -> {
      var jamal = new Student(
          1L,
          "Jamal",
          "jamal@gmail.com",
          LocalDate.of(2000, 12, 2));
      var kamal = new Student(
          2L,
          "Kamal",
          "kamal@gmail.com",
          LocalDate.of(2000, 12, 2));

      studentRepository.saveAll(List.of(jamal, kamal));
    };
  }
}
