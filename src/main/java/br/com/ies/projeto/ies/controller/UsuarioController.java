package br.com.ies.projeto.ies.controller;

import br.com.ies.projeto.ies.controller.dto.UsuarioDto;
import br.com.ies.projeto.ies.controller.form.UsuarioForm;
import br.com.ies.projeto.ies.modelo.Usuario;
import br.com.ies.projeto.ies.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> listar(){
        List<Usuario> all = usuarioRepository.findAll();
        List<UsuarioDto> usuariosDtos = new ArrayList<>();

        all.forEach(usuario -> {
            usuariosDtos.add(new UsuarioDto(usuario));
        });

        return ResponseEntity.ok(usuariosDtos);
    }

    @PostMapping
    private ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form) {
        Usuario usuario = form.converter();
        Usuario usuarioSave = usuarioRepository.save(usuario);

        return ResponseEntity.ok(new UsuarioDto(usuarioSave));
    }
}
