package br.com.ies.projeto.ies.repository;

import br.com.ies.projeto.ies.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
