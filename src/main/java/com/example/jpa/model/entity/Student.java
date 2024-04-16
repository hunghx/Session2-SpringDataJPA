package com.example.jpa.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NamedQuery(
        name = "findAll",query = "select S from Student S"
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int studentId;
    private String name;
    private int age;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Classes classes;
}
