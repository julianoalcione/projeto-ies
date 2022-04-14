package br.com.ies.projeto.ies.modelo;

public enum TipoUsuario {

    COORDENADOR(1, "coordenador"),
    PROFESSOR(2, "professor");

    private String descricao;
    private Integer id;

     TipoUsuario(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}