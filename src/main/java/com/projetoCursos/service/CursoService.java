package com.projetoCursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoCursos.entitie.Curso;
import com.projetoCursos.repository.CursoRepository;

@Service 
public class CursoService { 
private final CursoRepository cursoRepository; 

	@Autowired 
	public CursoService(CursoRepository cursoRepository) { 
		this.cursoRepository = cursoRepository; 
	} 

	public Curso saveCurso(Curso curso) { 
		return cursoRepository.save(curso); 
	} 

	public Curso getCursoById(Long id) { 
		return cursoRepository.findById(id).orElse(null); 
	} 

	public List<Curso> buscaTodosProdutos() { 
		return cursoRepository.findAll(); 
	} 

	public Curso buscaCursoId(Long id) { 
		Optional <Curso> drogaria = cursoRepository.findById(id); 
		return drogaria.orElse(null); 
	} 

	public Curso SalvaDrogaria(Curso curso) { 
		return cursoRepository.save(curso); 
	} 


	public Curso alterarCurso(Long id, Curso alterarCurso) { 
		Optional <Curso> existeCurso = cursoRepository.findById(id); 
		if (existeCurso.isPresent()) { 
			alterarCurso.setId(id); 
			return cursoRepository.save(alterarCurso); 
		} 
		return null; 
	} 

	public boolean apagarCurso(Long id) { 
		Optional <Curso> existeCurso = cursoRepository.findById(id); 
		if (existeCurso.isPresent()) { 
			cursoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 

} 