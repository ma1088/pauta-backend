package com.marilia.pa.pautabackend.dto;

import java.util.List;

import com.marilia.pa.pautabackend.model.Pauta;
import com.marilia.pa.pautabackend.model.Resposta;

public class PautaDTO {
    private Pauta pauta;
    private List<Resposta> respostas;
    
    public PautaDTO(Pauta pauta, List<Resposta> respostas) {
        this.pauta = pauta;
        this.respostas = respostas;
    }

    public Pauta getPauta() {
        return pauta;
    }
    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }
    public List<Resposta> getRespostas() {
        return respostas;
    }
    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

}
