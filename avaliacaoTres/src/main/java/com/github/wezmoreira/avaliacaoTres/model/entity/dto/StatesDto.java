package com.github.wezmoreira.avaliacaoTres.model.entity.dto;

import com.github.wezmoreira.avaliacaoTres.model.entity.States;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatesDto {

    private long id;
    private String nome;
    private String regiao;
    private int populacao;
    private String capital;
    private double area;

    public StatesDto(){
    }
    public StatesDto(States state){
        this.id = state.getId();
        this.nome = state.getName();
        this.regiao = state.getRegion();
        this.populacao = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public int getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }



    public static List<StatesDto> convert(List<States> state){
        return state.stream().map(StatesDto::new).collect(Collectors.toList());
    }

    public static List<StatesDto> convertDto(Optional<States> state){
        return state.stream().map(StatesDto::new).collect(Collectors.toList());
    }
}
