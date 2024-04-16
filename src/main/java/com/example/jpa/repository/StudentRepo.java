package com.example.jpa.repository;

import com.example.jpa.model.dto.response.StudentResponse;
import com.example.jpa.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Iterable<Student> findByNameContaining(String name);
    @Query("select new com.example.jpa.model.dto.response.StudentResponse(name,classes.name,age) from Student")
    List<StudentResponse> getAll();
    @Query("select case count(S) when 0 then false else true end from Student S where S.name like :name")
    boolean existsByName(@Param("name") String name);
}
