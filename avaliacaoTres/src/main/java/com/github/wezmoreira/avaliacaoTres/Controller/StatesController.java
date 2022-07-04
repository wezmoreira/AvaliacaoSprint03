package com.github.wezmoreira.avaliacaoTres.Controller;

import com.github.wezmoreira.avaliacaoTres.form.StatesForm;
import com.github.wezmoreira.avaliacaoTres.form.UpdateStatesForm;
import com.github.wezmoreira.avaliacaoTres.model.entity.States;
import com.github.wezmoreira.avaliacaoTres.model.entity.dto.StatesDto;
import com.github.wezmoreira.avaliacaoTres.repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StatesController {

    @Autowired
    private StatesRepository statesRepository;


    @PostMapping
    public ResponseEntity<StatesDto> postStates(@RequestBody @Valid StatesForm statesForm, UriComponentsBuilder uriBuilder){
        States states = statesForm.convert();
        statesRepository.save(states);

        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(states.getId()).toUri();
        return ResponseEntity.created(uri).body(new StatesDto(states));
    }


    @GetMapping
    public List<StatesDto> getStates(String region ){
        List<States> states = statesRepository.findAll();
        return StatesDto.convert(states);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatesDto> detalhar(@PathVariable Long id) {
        Optional<States> topico = statesRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new StatesDto(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StatesDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateStatesForm form) {
        Optional<States> optional = statesRepository.findById(id);
        if (optional.isPresent()) {
            States topico = form.update(id, statesRepository);
            return ResponseEntity.ok(new StatesDto(topico));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<States> optional = statesRepository.findById(id);
        if (optional.isPresent()) {
            statesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
