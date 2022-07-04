package com.github.wezmoreira.avaliacaoTres.model.entity.dto;

public class ErrorFormDto {

    private String attributes;
    private String error;

    public ErrorFormDto(String attributes, String error) {
        this.attributes = attributes;
        this.error = error;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getError() {
        return error;
    }
}
