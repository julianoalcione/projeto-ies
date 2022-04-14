package br.com.ies.projeto.ies.controller.form;

import br.com.ies.projeto.ies.modelo.Trabalho;
import br.com.ies.projeto.ies.modelo.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TrabalhoForm {

    private String materia;
    private String codMateria;
    private Integer anoAplicacao;
    private Integer fase;
    private String arquivoBase64;

    public Trabalho converter(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null && authentication.getPrincipal() == null)
            throw new IllegalArgumentException("Usuario nao encontrado");

        return new Trabalho(materia, codMateria, anoAplicacao, fase, (Usuario) authentication.getPrincipal(), arquivoBase64);
    }
}
