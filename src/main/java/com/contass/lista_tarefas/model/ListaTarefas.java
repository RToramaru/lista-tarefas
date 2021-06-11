package com.contass.lista_tarefas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Criação da entidade do banco de dados
 * criação dos métodos acessores
 * */
@Entity
@Table(name="TB_TAREFA")
public class ListaTarefas implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Codigo como id
     * Gerando automaticamente o codigo
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    /**
     * Definição do atributo como não nulo
     * */
    @NotNull
    private Date data;
    /**
     * Definição do atributo como não vazio
     * */
    @NotEmpty
    private String descricao;
    /**
     * Definição do atributo como não vazio
     * */
    @NotEmpty
    private String Usuario;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
}
