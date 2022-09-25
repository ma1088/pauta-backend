package com.marilia.pa.pautabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marilia.pa.pautabackend.dto.FiltroPautaDTO;
import com.marilia.pa.pautabackend.dto.PautaDTO;
import com.marilia.pa.pautabackend.model.Pauta;
import com.marilia.pa.pautabackend.model.Resposta;
import com.marilia.pa.pautabackend.repository.PautaRepository;
import com.marilia.pa.pautabackend.repository.RespostaRepository;


@ExtendWith(MockitoExtension.class)
public class PautaServiceTests {

    @Mock
    PautaRepository pautaRepo;

    @Mock
    RespostaRepository respostaRepo;

    @InjectMocks
    PautaService service;

    @Test
    public void criaPautaTest(){
        Pauta pauta = new Pauta(1L, "Juca", LocalDateTime.now().atZone(ZoneId.of("-3")), "Mais bolinhas", "insetos são viscosos mas gostosos, só que não têm procedência e não são abundantes. Por um mundo com mais bolinhas!", 1);
        List<String> respostas = Arrays.asList(new String[] {"sim", "não"});
        List<Resposta> resps = new ArrayList<Resposta>();
        respostas.forEach(r -> resps.add(new Resposta(0L, r)));

        configureRepositoryMocks(pautaRepo, pauta, pauta);
        configureRepositoryMocks(respostaRepo, resps.get(0), resps.get(1));


        PautaDTO aPauta = service.savePauta(pauta, resps);


        assertEquals("Juca",aPauta.getPauta().getAutor());
        assertEquals(2, aPauta.getRespostas().size());
        assertEquals("não", aPauta.getRespostas().get(1).getTexto());
    }

    @Test
    public void getPautasTest(){
        //quando
        /*when(pautaRepo.findAllByFilter(
            any(), 
            any(),
            any(), 
            any(), 
            any(), 
            any())).thenReturn(mockPautas());
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(new FiltroPautaDTO());

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(3, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());*/
    }

    private void configureRepositoryMocks(JpaRepository repository, Object toBeReturned1, Object toBeReturned2){
        when(repository.save(any()))
            .thenReturn(toBeReturned1)
            .thenReturn(toBeReturned2);
    }

    private List<Pauta> mockPautas(){
        List<Pauta> pautas = new ArrayList<>();
        for (Long i = 0L; i < 3; i++){
            pautas.add(new Pauta(i, "Juca", ZonedDateTime.now(), "titulo", "texto", 1));
        }
        return pautas;
    }

    private List<Resposta> mockRespostas(){
        List<Resposta> respostas = new ArrayList<>();
        respostas.addAll(Arrays.asList(new Resposta[] {
            new Resposta(0L, "sim"), 
            new Resposta(0L, "não")}
        ));
        return respostas;
    }
}
