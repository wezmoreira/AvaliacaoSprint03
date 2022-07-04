package com.github.wezmoreira.avaliacaoTres.repository;

import com.github.wezmoreira.avaliacaoTres.model.entity.States;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface StatesRepository extends JpaRepository<States, Long> {

    Optional<States> findById(@PathVariable long id);

    Optional<States> findByRegion(@PathVariable String region);



}
