package br.com.ies.projeto.ies.repository;

import br.com.ies.projeto.ies.modelo.Tcc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TccRepository extends JpaRepository<Tcc, Long> {


    @Query(value = "select * from tcc where titulo ilike %:titulo%", nativeQuery = true)
    Page<Tcc> findAllByTitulo(@Param("titulo") String titulo, Pageable page);
}
