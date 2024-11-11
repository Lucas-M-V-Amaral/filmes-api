package com.apiteste.filmesapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Filme implements Serializable{
    
    private long id;
    private String nome;
    private List<String> generos;
    private List<String> diretores;
    private List<String> atores;
    private String descricao;
    private double notaDoIMDB;
    private LocalDate dataDeLancamento;

    //Construtor Vazio
    public Filme() {

    }

    public Filme(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getGeneros() {
        return generos;
    }
    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }
    public List<String> getDiretores() {
        return diretores;
    }
    public void setDiretores(List<String> diretores) {
        this.diretores = diretores;
    }
    public List<String> getAtores() {
        return atores;
    }
    public void setAtores(List<String> atores) {
        this.atores = atores;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getNotaDoIMDB() {
        return notaDoIMDB;
    }
    public void setNotaDoIMDB(double notaDoIMDB) {
        this.notaDoIMDB = notaDoIMDB;
    }
    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }
    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((generos == null) ? 0 : generos.hashCode());
        result = prime * result + ((diretores == null) ? 0 : diretores.hashCode());
        result = prime * result + ((atores == null) ? 0 : atores.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        long temp;
        temp = Double.doubleToLongBits(notaDoIMDB);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((dataDeLancamento == null) ? 0 : dataDeLancamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Filme other = (Filme) obj;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (generos == null) {
            if (other.generos != null)
                return false;
        } else if (!generos.equals(other.generos))
            return false;
        if (diretores == null) {
            if (other.diretores != null)
                return false;
        } else if (!diretores.equals(other.diretores))
            return false;
        if (atores == null) {
            if (other.atores != null)
                return false;
        } else if (!atores.equals(other.atores))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (Double.doubleToLongBits(notaDoIMDB) != Double.doubleToLongBits(other.notaDoIMDB))
            return false;
        if (dataDeLancamento == null) {
            if (other.dataDeLancamento != null)
                return false;
        } else if (!dataDeLancamento.equals(other.dataDeLancamento))
            return false;
        return true;
    }
}
