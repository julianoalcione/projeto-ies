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
public class Trabalho {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String materia;
	private String codMateria;
	private Integer anoAplicacao;
	private Integer fase;
	private LocalDateTime dateInsert = LocalDateTime.now();
	@ManyToOne
	private Usuario usuario;
	private String arquivoBase64;

	public Trabalho(String materia, String codMateria, Integer anoAplicacao, Integer fase, Usuario usuario, String arquivoBase64) {
		this.materia = materia;
		this.codMateria = codMateria;
		this.anoAplicacao = anoAplicacao;
		this.fase = fase;
		this.usuario = usuario;
		this.arquivoBase64 = arquivoBase64;
	}
}