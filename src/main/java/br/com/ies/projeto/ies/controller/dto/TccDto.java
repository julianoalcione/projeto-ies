package br.com.ies.projeto.ies.controller.dto;

import br.com.ies.projeto.ies.modelo.Tcc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TccDto {
    private Long id;
    private String titulo;
    private String autor;
    private String professorResponsavel;
    private Integer ano;
    private Integer semestre;
    private String resumo;
    private LocalDateTime dateInsert;
    private Boolean publico;
    private CursoDto curso;
    private UsuarioDto usuario;
    private String arquivoBase6;

    public TccDto(Tcc tcc) {
        id = tcc.getId();
        titulo = tcc.getTitulo();
        autor = tcc.getAutor();
        professorResponsavel = tcc.getProfessorResponsavel();
        ano = tcc.getAno();
        semestre = tcc.getSemestre();
        resumo = tcc.getResumo();
        dateInsert = tcc.getDateInsert();
        publico = tcc.getPublico();
        curso = new CursoDto(tcc.getCurso());
        usuario = new UsuarioDto(tcc.getUsuario());
        arquivoBase6 = tcc.getArquivoBase64();
    }

    public static Page<TccDto> converter(Page<Tcc> all) {
        return all.map(TccDto::new);
    }
}
