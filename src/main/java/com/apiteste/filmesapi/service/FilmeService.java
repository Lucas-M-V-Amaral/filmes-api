package com.apiteste.filmesapi.service;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apiteste.filmesapi.model.Filme;

@Service
public class FilmeService {
    
    private static List<Filme> listaDeFilmes = new ArrayList<>();

    private void filmeFalso(){
        Filme filmeFalso = new Filme();
        filmeFalso.setId(1L);
        filmeFalso.setNome("A Crise");
        String[] generos = {"Ação", "Suspense", "Drama", "Musical"};
        filmeFalso.setGeneros(List.of(generos));
        String[] diretores = {"Quentin Tarantino"};
        filmeFalso.setDiretores(List.of(diretores));
        String[] atores = {"Nicholas Cage", "Lady Gaga", "Angelina Jolie", "Mark Ruffalo", "Leonardo DiCaprio"};
        filmeFalso.setAtores(List.of(atores));
        filmeFalso.setNotaDoIMDB(9.9);
        filmeFalso.setDataDeLancamento(LocalDate.of(2020, 12, 14));
        filmeFalso.setDescricao("Em meio a uma crise política nos EUA, uma série de assassinatos "
        + "de figuras importantes começa a ocorrer.");
        listaDeFilmes.add(filmeFalso);
    }

    public FilmeService(){
        filmeFalso();
    }

    public List<Filme> getAll(){
        return listaDeFilmes;
    }

    public Filme getById(Long id){
        Filme filmeId = new Filme(id);
        return listaDeFilmes.stream()
                            .filter(f -> f.equals(filmeId))
                            .findFirst().orElse(null);
    }

    public Filme get(Filme filme){
        return this.getById(filme.getId());
    }

    public List<Filme> getByGeneroList(String genero){
        return listaDeFilmes.stream()
                            .filter(f -> f.getGeneros().stream()
                                                         .filter(g -> g.equals(genero))
                                                         .count() > 0
                            ).toList();
    }

    public List<Filme> getByDiretores(String diretor){
        return listaDeFilmes.stream()
                            .filter(f -> f.getDiretores().stream()
                                                         .filter(d -> d.equals(diretor))
                                                         .count() > 0
                            ).toList();
    }

    public List<Filme> getByAtores(String ator){
        return listaDeFilmes.stream()
                            .filter(f -> f.getAtores().stream()
                                                     .filter(a -> a.equals(ator))
                                                     .count() > 0
                            ).toList();
    }

    public Boolean delete(Long id){
        Filme filme = this.getById(id);
        if (filme != null) {
            listaDeFilmes.remove(filme);
            return true;
        }
        return false;
    }

    public Filme create(Filme filme){
        listaDeFilmes.add(filme);
        return filme;
    }

    public Boolean update(Filme filmeParam){
        Filme _filme = this.get(filmeParam);

        if (_filme != null) {
            if (filmeParam.getGeneros() != null && filmeParam.getGeneros().size() > 0) {
                _filme.setGeneros(filmeParam.getGeneros());
            }
            if (filmeParam.getDiretores() != null && filmeParam.getDiretores().size() > 0) {
                _filme.setDiretores(filmeParam.getDiretores());
            }
            if (filmeParam.getAtores() != null && filmeParam.getAtores().size() > 0) {
                _filme.setAtores(filmeParam.getAtores());
            }
            if (!filmeParam.getNome().isEmpty()) {
                _filme.setNome(filmeParam.getNome());
            }
            if (filmeParam.getNotaDoIMDB() > 0) {
                _filme.setNotaDoIMDB(filmeParam.getNotaDoIMDB());
            }
            if (!filmeParam.getDescricao().isEmpty()) {
                _filme.setDescricao(filmeParam.getDescricao());
            }
            if (!filmeParam.getDataDeLancamento().toString().isEmpty()) {
                _filme.setDataDeLancamento(filmeParam.getDataDeLancamento());
            }
            return true;
        }
        return false;
    }





}
