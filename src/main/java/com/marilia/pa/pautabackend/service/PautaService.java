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
        List<Pauta> pautas = buscaPautasPorFiltro(filtro);

        List<PautaDTO> pautasComRespostas = new ArrayList<>();
        pautas.forEach(p -> {
            List<Resposta> respostas = respostaRepo.findAllByIdPauta(p.getIdPauta());
            pautasComRespostas.add(new PautaDTO(p, respostas));
        });
        return pautasComRespostas;
    }

    private List<Pauta> buscaPautasPorFiltro(FiltroPautaDTO filtro){
        if (filtro.getCriadoApos() != null && filtro.getCriadoAntesDe() != null){
            return pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoIsBetween
                (filtro.getAutorLike(), filtro.getTituloLike(), filtro.getTextoLike(),
                filtro.getCriadoApos(), filtro.getCriadoAntesDe());
        } else if (filtro.getCriadoApos() != null && filtro.getCriadoAntesDe() == null){
            return pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoGreaterThanEqual
                (filtro.getAutorLike(), filtro.getTituloLike(), filtro.getTextoLike(),
                filtro.getCriadoApos());
        } else if (filtro.getCriadoApos() == null && filtro.getCriadoAntesDe() != null){
            return pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoLessThanEqual
                (filtro.getAutorLike(), filtro.getTituloLike(), filtro.getTextoLike(), 
                filtro.getCriadoAntesDe());
        } else {
            return pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContains(
                filtro.getAutorLike(), filtro.getTituloLike(), filtro.getTextoLike());
        }
    }
}
