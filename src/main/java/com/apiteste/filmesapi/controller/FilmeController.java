package com.apiteste.filmesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.apiteste.filmesapi.service.FilmeService;
import com.apiteste.filmesapi.model.Filme;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping
    public ResponseEntity<List<Filme>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(params = "genero")
    public ResponseEntity<List<Filme>> getByGenero(@RequestParam String genero){
        return ResponseEntity.of(Optional.of(service.getByGeneros(genero)));
    }

    @GetMapping(params = "diretor")
    public ResponseEntity<List<Filme>> getByDiretor(@RequestParam String diretor){
        return ResponseEntity.of(Optional.of(service.getByDiretores(diretor)));
    }

    @GetMapping(params = "ator")
    public ResponseEntity<List<Filme>> getByAtor(@RequestParam String ator){
        return ResponseEntity.of(Optional.of(service.getByAtores(ator)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getById(@PathVariable("id") Long id){
        return ResponseEntity.of(Optional.of(service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<Filme> create(@RequestBody Filme filme){
        service.create(filme);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(filme.getId())
                            .toUri();
        return ResponseEntity.created(location).body(filme);
    }

    @PutMapping
    public ResponseEntity<Filme> update(@RequestBody Filme filme){
        if (service.update(filme)) {
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> delete(@PathVariable("id") Long id){
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
