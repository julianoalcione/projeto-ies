package br.com.ies.projeto.ies.controller;

import br.com.ies.projeto.ies.controller.dto.CursoDto;
import br.com.ies.projeto.ies.controller.form.CursoForm;
import br.com.ies.projeto.ies.modelo.Curso;
import br.com.ies.projeto.ies.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping()
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm form){

        Curso tcc = form.converter();
        Curso curso = cursoRepository.save(tcc);

        return ResponseEntity.ok(new CursoDto(curso));
    }

    @GetMapping()
    public ResponseEntity<List<CursoDto>> listar(){

        List<Curso> all = cursoRepository.findAll();
        List<CursoDto> cursosDtos = new ArrayList<>();

        all.forEach(curso -> {
            cursosDtos.add(new CursoDto(curso));
        });;

        return ResponseEntity.ok(cursosDtos);
    }
}
