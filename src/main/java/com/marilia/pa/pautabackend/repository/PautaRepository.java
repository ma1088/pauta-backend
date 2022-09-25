package com.marilia.pa.pautabackend.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marilia.pa.pautabackend.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

    List<Pauta> findAllByAutorContains(String autorLike);
    /*@Query("select id_pauta, autor,  titulo, texto, dt_criacao, qtd_respostas " +
           "  from tb_pauta " +
           " where dt_criacao <= coalesce(:dtCriacaoAntes, dt_criacao) " +
           "   and dt_criacao > coalesce (:dtCriacaoApos, dt_criacao) " +
           "   and (   autor like concat('%', :autorLike, '%') " +
           "        or autor in :autorIn) " +
           "   and titulo like concat('%', :tituloLike, '%') " +
           "   and texto like concat('%', :textoLike, '%')"
           )
    public List<Pauta> findAllByFilter(
        @Param("dtCriacaoAntes") ZonedDateTime dtCriacaoAntes,
        @Param("dtCriacaoApos") ZonedDateTime dtCriacaoApos,
        @Param("autorLike") String autorLike,
        @Param("autorIn") List<String> autorIn,
        @Param("tituloLike") String tituloLike,
        @Param("textoLike") String textoLike);*/
    
}
