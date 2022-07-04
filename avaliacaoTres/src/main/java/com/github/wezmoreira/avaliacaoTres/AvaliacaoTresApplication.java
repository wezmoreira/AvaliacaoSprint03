package com.github.wezmoreira.avaliacaoTres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class AvaliacaoTresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoTresApplication.class, args);
	}

}
