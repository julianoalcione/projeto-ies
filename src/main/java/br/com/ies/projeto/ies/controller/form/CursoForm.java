package br.com.ies.projeto.ies.controller.form;

import br.com.ies.projeto.ies.modelo.Curso;
import br.com.ies.projeto.ies.modelo.Tcc;
import br.com.ies.projeto.ies.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoForm {
    private String descricao;

    public Curso converter(){
        return new Curso(descricao);
    }
}
