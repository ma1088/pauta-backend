package com.marilia.pa.pautabackend.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPauta;
    @Column
    private String autor;
    @Column
    private ZonedDateTime dtCriacao;
    @Column
    private String titulo;
    @Column
    private String texto;
    @Column
    private Integer qtdRespostas;

    public Pauta(){

    }

    public Pauta(String autor, ZonedDateTime dtCriacao, String titulo, String texto, Integer qtdRespostas){
        this.autor = autor;
        this.dtCriacao = dtCriacao;
        this.titulo = titulo;
        this.texto = texto;
        this.qtdRespostas = qtdRespostas;
    }

    public Pauta(Long idPauta, String autor, ZonedDateTime dtCriacao, String titulo, String texto, Integer qtdRespostas){
        this.idPauta = idPauta;
        this.autor = autor;
        this.dtCriacao = dtCriacao;
        this.titulo = titulo;
        this.texto = texto;
        this.qtdRespostas = qtdRespostas;
    }

    public Long getIdPauta() {
        return idPauta;
    }
    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public ZonedDateTime getDtCriacao() {
        return dtCriacao;
    }
    public void setDtCriacao(ZonedDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Integer getQtdRespostas() {
        return qtdRespostas;
    }
    public void setQtdRespostas(Integer qtdRespostas) {
        this.qtdRespostas = qtdRespostas;
    }
}
