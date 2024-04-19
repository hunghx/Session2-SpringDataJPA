package com.example.jpa.api;

import com.example.jpa.model.entity.Student;
import com.example.jpa.repository.StudentRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api.example.com/students")
@CrossOrigin("*")
public class StudentControllerAPI {
    @Autowired
    private StudentRepo studentRepo;

    // tra ve danh sach hoc sinh
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id){
        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    // thêm mới
    @PostMapping
    public ResponseEntity<Student> doAdd(@RequestBody Student student){
        Student s = studentRepo.save(student);
        return ResponseEntity.ok(s);
    }

    // sửa
    @PutMapping("/{id}")
    public ResponseEntity<Student> doUpdate(@RequestBody Student student,@PathVariable Integer id){
        studentRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        student.setStudentId(id);
        Student s = studentRepo.save(student);
        return ResponseEntity.ok(s);
    }
    // xoa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Integer id){
        studentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
