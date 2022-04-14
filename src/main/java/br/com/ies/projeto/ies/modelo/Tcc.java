package br.com.ies.projeto.ies.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tcc {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String professorResponsavel;
	private Integer ano;
	private Integer semestre;
	private String resumo;
	private LocalDateTime dateInsert = LocalDateTime.now();
	private Boolean publico;
	@ManyToOne
	private Usuario usuario;
	@OneToOne
	private Curso curso;
	private String arquivoBase64;

    public Tcc(String titulo, String autor, String professorResponsavel, Integer ano,
			   Integer semestre, String resumo, Boolean publico, Curso curso, Usuario usuario, String arquivoBase64) {
    	this.titulo = titulo;
		this.autor = autor;
		this.professorResponsavel = professorResponsavel;
		this.ano = ano;
		this.semestre = semestre;
		this.resumo = resumo;
		this.publico = publico;
		this.curso = curso;
		this.usuario = usuario;
		this.arquivoBase64 = arquivoBase64;
    }
}