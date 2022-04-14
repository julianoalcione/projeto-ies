package br.com.ies.projeto.ies.controller.dto;

import br.com.ies.projeto.ies.modelo.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class CursoDto
{
    private Long id;
    private String descricao;

    public CursoDto(Curso curso){
        this.id = curso.getId();
        this.descricao = curso.getDescricao();
    }
}
