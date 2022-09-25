package com.marilia.pa.pautabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResposta;
    @Column
    private Long idPauta;
    @Column
    private String texto;

    public Resposta(){

    }

    public Resposta(Long idPauta, String texto){
        this.idPauta = idPauta;
        this.texto = texto;
    }

    public Long getIdResposta() {
        return idResposta;
    }
    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }
    public Long getIdPauta() {
        return idPauta;
    }
    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
