package br.com.ies.projeto.ies.controller.form;

import br.com.ies.projeto.ies.modelo.Curso;
import br.com.ies.projeto.ies.modelo.Tcc;
import br.com.ies.projeto.ies.modelo.Usuario;
import br.com.ies.projeto.ies.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TccForm {
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private String professorResponsavel;
    @NotNull
    private Integer ano;
    @NotNull
    private Integer semestre;
    @NotBlank
    private String resumo;
    @NotNull
    private Boolean publico;
    private Long cursoId;
//    @NotEmpty
    private String arquivoBase64;

    public Tcc converter(CursoRepository cursoRepository){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null && authentication.getPrincipal() == null)
            throw new IllegalArgumentException("Usuario nao encontrado");

        Optional<Curso> curso = cursoRepository.findById(cursoId);

        if(!curso.isPresent())
            throw new IllegalArgumentException("Curso nao encontrado");

        return new Tcc(titulo, autor, professorResponsavel, ano, semestre, resumo, publico, curso.get(), (Usuario) authentication.getPrincipal(), arquivoBase64);
    }
}
