package com.example.graphqlcursosapi.repository;

import com.example.graphqlcursosapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface CursoRepository extends JpaRepository<Curso, Long>{
}
