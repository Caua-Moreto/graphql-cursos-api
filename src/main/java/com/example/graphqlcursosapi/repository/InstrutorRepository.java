package com.example.graphqlcursosapi.repository;

import com.example.graphqlcursosapi.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
}