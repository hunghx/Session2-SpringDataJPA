package com.example.jpa.repository;

import com.example.jpa.model.entity.Classes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassessRepo extends PagingAndSortingRepository<Classes,String> {
}
