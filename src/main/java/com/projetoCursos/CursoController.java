package com.projetoCursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoCursos.entitie.Curso;
import com.projetoCursos.service.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("/cursos") 
@Tag(name = "Cursos", description="API REST DE GERENCIAMENTO DE CURSOS")
@CrossOrigin(origins = "*")
public class CursoController { 
	private final CursoService cursoService; 

	@Autowired 
	public CursoController(CursoService cursoService) { 
		this.cursoService = cursoService; 
	} 

	@GetMapping("/{id}") 
	@Operation(summary = "Localiza curso por ID")
	public ResponseEntity<Curso> buscaCursoControlId (@PathVariable Long id){ 
		Curso curso = cursoService.buscaCursoId(id); 
		if(curso != null) { 
			return ResponseEntity.ok(curso); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping
	@Operation(summary = "Apresenta todos os cursos")
	public ResponseEntity<List<Curso>> buscaTodosCursoControl(){ 
		List<Curso> curso = cursoService.buscaTodosProdutos(); 
		return ResponseEntity.ok(curso); 
	} 

	@PostMapping
	@Operation(summary = "Cadastra um cursos")
	public ResponseEntity<Curso> salvaCursoControl(@RequestBody Curso curso){ 
		Curso salvaCurso = cursoService.saveCurso(curso); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCurso); 
	} 

	@PutMapping("/{id}") 
	@Operation(summary = "Alterar um cursos")
	public ResponseEntity<Curso> alteraCursoControl(@PathVariable Long codigo, @RequestBody Curso curso){ 
		Curso alteraCurso = cursoService.alterarCurso(codigo, curso); 
		if (alteraCurso != null) { 
			return ResponseEntity.ok(curso); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		}
	} 

	@DeleteMapping("/{id}")
	@Operation(summary = "Apagar um cursos")
	public ResponseEntity<String> apagaCursoControl(@PathVariable Long codigo){ 
		boolean apagar = cursoService.apagarCurso(codigo); 
		if(apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 
		else { 
			return ResponseEntity.notFound().build();  
		} 
	} 



} 
