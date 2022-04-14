package br.com.ies.projeto.ies.controller.dto;

import br.com.ies.projeto.ies.modelo.Trabalho;
import br.com.ies.projeto.ies.modelo.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TrabalhoDto {
    private Long id;
    private String materia;
    private String codMateria;
    private Integer anoAplicacao;
    private Integer fase;
    private LocalDateTime dateInsert = LocalDateTime.now();
    private Usuario usuario;
    private String arquivoBase64;

    public TrabalhoDto(Trabalho trabalho) {
        this.materia = trabalho.getMateria();
        this.codMateria = trabalho.getCodMateria();
        this.anoAplicacao = trabalho.getAnoAplicacao();
        this.fase = trabalho.getFase();
        this.usuario = trabalho.getUsuario();
        this.arquivoBase64 = trabalho.getArquivoBase64();
    }

    public static Page<TrabalhoDto> converter(Page<Trabalho> all) {
        return all.map(TrabalhoDto::new);
    }

}
