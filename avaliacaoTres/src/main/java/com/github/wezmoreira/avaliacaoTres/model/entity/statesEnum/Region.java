package com.github.wezmoreira.avaliacaoTres.model.entity.statesEnum;

public enum Region {

    //LEMBRAR DE TERMINAR
    SUL("Sul"),
    SUDESTE("Sudeste"),
    NORTE("Norte"),
    NORDESTE("Nordeste"),
    CENTRO_OESTE("Centro oeste");

    private String states;
    Region(String name) {
        this.states = name;
    }
    public String getStates() {
        return states;
    }
}
