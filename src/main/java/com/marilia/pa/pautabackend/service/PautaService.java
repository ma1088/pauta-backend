package com.marilia.pa.pautabackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marilia.pa.pautabackend.dto.FiltroPautaDTO;
import com.marilia.pa.pautabackend.dto.PautaDTO;
import com.marilia.pa.pautabackend.model.Pauta;
import com.marilia.pa.pautabackend.model.Resposta;
import com.marilia.pa.pautabackend.repository.PautaRepository;
import com.marilia.pa.pautabackend.repository.RespostaRepository;

@Service
public class PautaService {

    @Autowired
    PautaRepository pautaRepo;

    @Autowired
    RespostaRepository respostaRepo;

    public PautaDTO savePauta(Pauta pauta, List<Resposta> respostas){
        pauta = pautaRepo.save(pauta);
        List<Resposta> resps = saveRespostas(pauta, respostas);
        return new PautaDTO(pauta, resps);
    }
    
    public List<Resposta> saveRespostas(Pauta pauta, List<Resposta> respostas){
        List<Resposta> resps = new ArrayList<>();
        respostas.forEach(resp -> resps.add(respostaRepo.save(new Resposta(pauta.getIdPauta(), resp.getTexto()))));
        return resps;
    }

    public List<PautaDTO> getPautas(FiltroPautaDTO filtro) {
        /*List<Pauta> pautas = pautaRepo.findAllByFilter(filtro.getCriadoAntesDe(),
                                                       filtro.getCriadoApos(),
                                                       filtro.getAutorLike(),
                                                       filtro.getAutoresIn(),
                                                       filtro.getTituloLike(),
                                                       filtro.getTextoLike());*/
        List<Pauta> pautas = pautaRepo.findAllByAutorContains(filtro.getAutorLike());
        List<PautaDTO> pautasComRespostas = new ArrayList<>();
        pautas.forEach(p -> {
            List<Resposta> respostas = respostaRepo.findAllByIdPauta(p.getIdPauta());
            pautasComRespostas.add(new PautaDTO(p, respostas));
        });
        return pautasComRespostas;
    }
}
