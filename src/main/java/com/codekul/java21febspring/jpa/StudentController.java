package com.codekul.java21febspring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("save")
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "student saved.";
    }

    @GetMapping("list")
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @GetMapping("getStudent/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentRepository.getReferenceById(id);
    }
   @GetMapping("getStudent/{id}")
    public Optional<Student> getStudent1(@PathVariable("id") Long id) {
        return studentRepository.findById(id);
    }
}
