package com.marilia.pa.pautabackend.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FiltroPautaDTO {
    private ZonedDateTime criadoAntesDe;
    private ZonedDateTime criadoApos;
    private String autorLike;
    private String tituloLike;
    private String textoLike;

    public FiltroPautaDTO(){

    }

    public FiltroPautaDTO(ZonedDateTime criadoAntesDe, 
                          ZonedDateTime criadoApos, 
                          String autorLike, 
                          String tituloLike, 
                          String textoLike){
        this.criadoAntesDe = criadoAntesDe;
        this.criadoApos = criadoApos;
        this.autorLike = autorLike;
        this.tituloLike = tituloLike;
        this.textoLike = textoLike;
    }
    
    public ZonedDateTime getCriadoAntesDe() {
        return criadoAntesDe;
    }
    public void setCriadoAntesDe(ZonedDateTime criadoAntesDe) {
        this.criadoAntesDe = criadoAntesDe;
    }
    public ZonedDateTime getCriadoApos() {
        return criadoApos;
    }
    public void setCriadoApos(ZonedDateTime criadoApos) {
        this.criadoApos = criadoApos;
    }
    public String getAutorLike() {
        return autorLike;
    }
    public void setAutorLike(String autorLike) {
        this.autorLike = autorLike;
    }
    public String getTituloLike() {
        return tituloLike;
    }
    public void setTituloLike(String tituloLike) {
        this.tituloLike = tituloLike;
    }
    public String getTextoLike() {
        return textoLike;
    }
    public void setTextoLike(String textoLike) {
        this.textoLike = textoLike;
    }

}
