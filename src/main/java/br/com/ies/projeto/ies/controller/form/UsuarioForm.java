package br.com.ies.projeto.ies.controller.form;

import br.com.ies.projeto.ies.modelo.TipoUsuario;
import br.com.ies.projeto.ies.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioForm {

    @NotBlank
    private String nome;
    @NotNull
    private TipoUsuario tipoUsuario;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    public UsuarioForm(String nome, TipoUsuario tipoUsuario, String email, String senha) {
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    public Usuario converter(){
        return new Usuario(nome, tipoUsuario, email, senha);
    }
}
