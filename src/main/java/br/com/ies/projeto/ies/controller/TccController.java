package br.com.ies.projeto.ies.controller;

import br.com.ies.projeto.ies.controller.dto.TccDto;
import br.com.ies.projeto.ies.controller.dto.TrabalhoDto;
import br.com.ies.projeto.ies.controller.form.TccForm;
import br.com.ies.projeto.ies.modelo.Tcc;
import br.com.ies.projeto.ies.modelo.Trabalho;
import br.com.ies.projeto.ies.repository.CursoRepository;
import br.com.ies.projeto.ies.repository.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/tcc")
public class TccController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TccRepository tccRepository;

    @PostMapping()
    public ResponseEntity<TccDto> cadastrar(@RequestBody @Valid TccForm form){

        Tcc tcc = form.converter(cursoRepository);
        Tcc save = tccRepository.save(tcc);

        return ResponseEntity.ok(new TccDto(save));
    }

    @GetMapping()
    public ResponseEntity<Page<TccDto>> listar(@RequestParam(required = false) String titulo,
        @PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, size = 10)Pageable page){

        Page<Tcc> all = titulo != null ? tccRepository.findAllByTitulo(titulo, page): tccRepository.findAll(page);
        Page<TccDto> tccsDtos = TccDto.converter(all);

        return ResponseEntity.ok(tccsDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TccDto> detalhar(@PathParam("id") Long id){

        Optional<Tcc> tcc = tccRepository.findById(id);
        if(tcc.isPresent()){
            return ResponseEntity.ok(new TccDto(tcc.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
