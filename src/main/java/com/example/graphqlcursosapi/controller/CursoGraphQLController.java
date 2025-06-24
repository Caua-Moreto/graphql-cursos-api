package com.example.graphqlcursosapi.controller; // ajuste o pacote se necessário

import com.example.graphqlcursosapi.entity.Curso;
import com.example.graphqlcursosapi.entity.Instrutor;
import com.example.graphqlcursosapi.repository.CursoRepository;
import com.example.graphqlcursosapi.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CursoGraphQLController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @QueryMapping
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @QueryMapping
    public Curso buscarCursoPorId(@Argument Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Instrutor criarInstrutor(@Argument String nome, @Argument String email) {
        Instrutor novoInstrutor = new Instrutor();
        novoInstrutor.setNome(nome);
        novoInstrutor.setEmail(email);
        return instrutorRepository.save(novoInstrutor);
    }

    @MutationMapping
    public Curso criarCurso(@Argument String nome, @Argument String descricao, @Argument Long instrutorId) {
        Instrutor instrutor = instrutorRepository.findById(instrutorId)
            .orElseThrow(() -> new IllegalArgumentException("Instrutor com ID " + instrutorId + " não encontrado."));

        Curso novoCurso = new Curso();
        novoCurso.setNome(nome);
        novoCurso.setDescricao(descricao);
        novoCurso.setInstrutor(instrutor);

        return cursoRepository.save(novoCurso);
    }
}