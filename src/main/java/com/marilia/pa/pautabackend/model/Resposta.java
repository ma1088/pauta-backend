package com.marilia.pa.pautabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resposta {

    @Id
    @GeneratedValue
    private Long idResposta;
    @Column
    private Long idPergunta;
    @Column
    private String texto;

    public Resposta(){

    }

    public Resposta(Long idPergunta, String texto){
        this.idPergunta = idPergunta;
        this.texto = texto;
    }

    public Long getIdResposta() {
        return idResposta;
    }
    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }
    public Long getIdPergunta() {
        return idPergunta;
    }
    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
