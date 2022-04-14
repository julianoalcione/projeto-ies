package br.com.ies.projeto.ies.controller.dto;

import br.com.ies.projeto.ies.modelo.TipoUsuario;
import br.com.ies.projeto.ies.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private TipoUsuario tipoUsuario;
    private String email;

    public UsuarioDto(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        tipoUsuario = usuario.getTipoUsuario();
        email = usuario.getEmail();
    }
}
