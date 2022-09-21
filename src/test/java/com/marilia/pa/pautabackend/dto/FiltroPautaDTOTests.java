package com.marilia.pa.pautabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FiltroPautaDTOTests {

    public FiltroPautaDTO buildMock(){
        FiltroPautaDTO filtro = new FiltroPautaDTO();
        return filtro;
    }

    @Test
    public void getAndSetCriadoAntesDeTest(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setCriadoAntesDe(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")));

        //então
        assertEquals(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")), filtro.getCriadoAntesDe());
    }

    @Test
    public void getAndSetCriadoAposTest(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setCriadoApos(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")));

        //então
        assertEquals(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")), filtro.getCriadoApos());
    }

    @Test
    public void getSetAutorLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setAutorLike("Ju");

        //então
        assertEquals("Ju", filtro.getAutorLike());
    }

    @Test
    public void getSetTituloLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setTituloLike("água");

        //entao
        assertEquals("água", filtro.getTituloLike());
    }

    @Test
    public void getSetTextoLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setTextoLike("água");

        //entao
        assertEquals("água", filtro.getTextoLike());
    }

    @Test
    public void getSetAutoresIn(){
        //dado
        FiltroPautaDTO filtro = buildMock();
        String[] autoresRef = {"Juca", "Alana", "Debi"};
        ArrayList<String> autores = new ArrayList<String>(Arrays.asList(autoresRef));

        //quando
        filtro.setAutoresIn(autores);

        //entao
        String[] autoresToAssert = filtro.getAutoresIn().toArray(new String[0]);
        assertEquals(autoresRef.length, autoresToAssert.length);
        for (int i = 0; i < autoresRef.length; i++){
            assertEquals(i + "-" + autoresRef[i], i + "-" + autoresToAssert[i]);
        }    }
}
