package com.marilia.pa.pautabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
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
    public void getPautasTest_ByAutorAndTituloAndTextAndDtCriacaoBetween(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();

        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoIsBetween
            (anyString(), anyString(), anyString(), any(ZonedDateTime.class), any(ZonedDateTime.class)))
            .thenReturn(mockPautas(2));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(2, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_ByAutorAndTituloAndTextAndDtCriacaoLessThanEquals(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();

        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoLessThanEqual
            (anyString(), anyString(), anyString(), any(ZonedDateTime.class)))
            .thenReturn(mockPautas(3));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(3, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_ByAutorAndTituloAndTextAndDtCriacaoGreaterThanEquals(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();
        
        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContainsAndDtCriacaoGreaterThanEqual
                        (anyString(), anyString(), anyString(), any(ZonedDateTime.class)))
                        .thenReturn(mockPautas(3));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(4, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_ByAutorAndTituloAndText(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();
        
        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContains
            (anyString(), anyString(), anyString()))
            .thenReturn(mockPautas(5));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(5, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_ByAutorAndTitulo(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();
        
        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContains
            (anyString(), anyString(), any()))
            .thenReturn(mockPautas(6));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(6, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_ByAutor(){
        //Dado
        FiltroPautaDTO filtro = mockFiltro();
        
        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContains
            (anyString(), any(), any()))
            .thenReturn(mockPautas(7));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(7, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    public void getPautasTest_AllRecords(){
        //Dado
        FiltroPautaDTO filtro = new FiltroPautaDTO();
        
        //quando
        when(pautaRepo.findAllByAutorContainsAndTituloContainsAndTextoContains
            (any(), any(), any()))
            .thenReturn(mockPautas(8));
        when(respostaRepo.findAllByIdPauta(anyLong())).thenReturn(mockRespostas());
        List<PautaDTO> pDto = service.getPautas(filtro);

        //então
        assertNotNull(pDto);
        assertNotNull(pDto.get(0).getPauta());
        assertNotNull(pDto.get(0).getRespostas());
        assertEquals(8, pDto.size());
        assertEquals(2,pDto.get(0).getRespostas().size());
    }

    private void configureRepositoryMocks(JpaRepository repository, Object toBeReturned1, Object toBeReturned2){
        when(repository.save(any()))
            .thenReturn(toBeReturned1)
            .thenReturn(toBeReturned2);
    }

    private FiltroPautaDTO mockFiltro(){
        ZonedDateTime dtMaxima = ZonedDateTime.of(2022, 9, 1, 0, 0, 0, 0, ZoneId.of("-03:00"));
        ZonedDateTime dtMinima = ZonedDateTime.of(2022,9,30,0,0,0,0,ZoneId.of("-03:00"));
        return new FiltroPautaDTO(dtMaxima, dtMinima, "Juca", "Bolinhas", "bolinhas");

    }

    private List<Pauta> mockPautas(int qtdPautas){
        List<Pauta> pautas = new ArrayList<>();
        for (Long i = 0L; i < qtdPautas; i++){
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
