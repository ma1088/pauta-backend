package com.marilia.pa.pautabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marilia.pa.pautabackend.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long>{

    public List<Resposta> findAllByIdPauta(Long idPauta);
}
