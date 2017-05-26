package com.example.jeancarlos.snapfootball.Model;

import java.io.Serializable;

/**
 * Created by Jean Carlos on 26/05/2017.
 */

public class Anuncio implements Serializable{

    private Long id_anuncio;
    private String descricao;
    private String categoria;
    private String marca;
    private String estado;
    private Double preco;
    private Long usuario_id;

    public Long getId_anuncio() {
        return id_anuncio;
    }
    public void setId_anuncio(Long id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
