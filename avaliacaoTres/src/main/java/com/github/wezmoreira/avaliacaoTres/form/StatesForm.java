package com.github.wezmoreira.avaliacaoTres.form;

import com.github.wezmoreira.avaliacaoTres.model.entity.States;
import com.github.wezmoreira.avaliacaoTres.repository.StatesRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class StatesForm {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String region;

    @NotNull @PositiveOrZero
    private int population;

    @NotNull @NotEmpty
    private String capital;

    @NotNull @PositiveOrZero
    private double area;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public States convert(){
        return new States(name, region, population, capital, area);
    }

    public States update(long id, StatesRepository statesRepository) {
        States states = statesRepository.getOne(id);
        states.setName(this.name);
        states.setRegion(this.region);
        states.setPopulation(this.population);
        states.setCapital(this.capital);
        states.setArea(this.area);

        return states;
    }

}
