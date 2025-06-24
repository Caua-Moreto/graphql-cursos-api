package com.example.graphqlcursosapi.controller;

import com.example.graphqlcursosapi.entity.Curso;
import com.example.graphqlcursosapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CursoGraphQLController {

    @Autowired
    // Injetei o repositório direto nessa parte do código para que não
    // houvesse necessidade dos Services
    private CursoRepository cursoRepository; 

    // query "listarCursos" do schema.
    // O nome do método DEVE ser igual ao nome da query.
    
    @QueryMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // query "buscarCursoPorId" do schema.
    // A anotação @Argument pega o valor do 'id' passado na query GraphQL.
    
    @QueryMapping
    public Curso buscarCursoPorId(@Argument Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}