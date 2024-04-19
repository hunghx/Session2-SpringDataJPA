package com.example.jpa.controller;

import com.example.jpa.model.dto.response.StudentResponse;
import com.example.jpa.model.entity.Classes;
import com.example.jpa.model.entity.Student;
import com.example.jpa.repository.ClassessRepo;
import com.example.jpa.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassessRepo classessRepo;
    @RequestMapping
    public String test(@RequestParam(defaultValue = "0") int page, Model model){
//        List<StudentResponse> students = studentRepo.getAll();
        List<Student> student1s = studentRepo.findAll();

        // Pageable
//        Sort sort = Sort.by("name").descending();
//        Pageable pageableCustom  = PageRequest.of(page,2,sort);
//        Page<Student> pages =  studentRepo.findAll(pageableCustom);
//        Iterator<Student> iterator = students.iterator();
//        while (iterator.hasNext()){
//            Student next = iterator.next();
//            System.out.println(next);
//            Classes classes = next.getClasses();
//            System.out.println(classes);
//        }
//        model.addAttribute("students",students);


//        Student student = studentRepo.findById(1).orElse(null);
//        if (student!=null){
//            student.getClasses().setName("PHP");
//            student.setName("Hung PHP");
//            studentRepo.save(student);
//        }

//        classessRepo.deleteById("1");
//        model.addAttribute("page",pages);

//        boolean check  = studentRepo.existsByName("hung");

        return "home";
    }
}
