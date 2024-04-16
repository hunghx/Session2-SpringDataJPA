package com.example.jpa.repository;

import com.example.jpa.model.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class StudentRepoImpl {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Student> list(){
        return entityManager.createNamedQuery("findAll").getResultList();
    }
}
