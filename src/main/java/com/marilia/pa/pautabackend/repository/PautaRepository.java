package com.marilia.pa.pautabackend.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marilia.pa.pautabackend.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

    List<Pauta> findAllByAutorContainsAndTituloContainsAndTextoContains(
        String autorLike, String tituloLike, String textoLike);

    List<Pauta> findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoGreaterThanEqual(
        String autorLike, String tituloLike, String textoLike, ZonedDateTime dtMinimo);
        
    List<Pauta> findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoLessThanEqual(
        String autorLike, String tituloLike, String textoLike, ZonedDateTime dtMaximo);

    List<Pauta> findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoIsBetween(
        String autorLike, String tituloLike, String textoLike, ZonedDateTime dtMinimo, ZonedDateTime dtMaximo);
}
