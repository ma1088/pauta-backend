package com.marilia.pa.pautabackend.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class FiltroPautaDTO {
    private ZonedDateTime criadoAntesDe;
    private ZonedDateTime criadoApos;
    private String autorLike;
    private String tituloLike;
    private String textoLike;
    private List<String> autoresIn;
    
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
    public List<String> getAutoresIn() {
        return autoresIn;
    }
    public void setAutoresIn(List<String> autoresIn) {
        this.autoresIn = autoresIn;
    }

}
