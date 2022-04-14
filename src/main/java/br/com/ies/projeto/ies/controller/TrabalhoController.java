package br.com.ies.projeto.ies.controller;

import br.com.ies.projeto.ies.controller.dto.TrabalhoDto;
import br.com.ies.projeto.ies.controller.form.TrabalhoForm;
import br.com.ies.projeto.ies.modelo.Trabalho;
import br.com.ies.projeto.ies.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @PostMapping()
    public ResponseEntity<TrabalhoDto> cadastrar(@RequestBody @Valid TrabalhoForm form){

        Trabalho trabalho = form.converter();
        Trabalho save = trabalhoRepository.save(trabalho);

        return ResponseEntity.ok(new TrabalhoDto(save));
    }

    @GetMapping()
    public ResponseEntity<Page<TrabalhoDto>> listar(@PageableDefault(size = 10)Pageable page){

        Page<Trabalho> all = trabalhoRepository.findAll(page);
        Page<TrabalhoDto> trabalhosDtos = TrabalhoDto.converter(all);

        return ResponseEntity.ok(trabalhosDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDto> detalhar(@PathParam("id") Long id){

        Optional<Trabalho> trabalho = trabalhoRepository.findById(id);
        if(trabalho.isPresent()){
            return ResponseEntity.ok(new TrabalhoDto(trabalho.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
