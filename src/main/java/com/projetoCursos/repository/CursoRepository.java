package com.projetoCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoCursos.entitie.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
