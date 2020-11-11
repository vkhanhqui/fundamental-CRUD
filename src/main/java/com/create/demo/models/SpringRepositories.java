package com.create.demo.models;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface SpringRepositories extends JpaRepository<SpringModels, String> {
    List<SpringModels> findAllBySttOrderByIdAsc(int stt);
}



