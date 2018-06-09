package br.feevale.ads.simuladorestocastico.model;

import java.util.Map;

/**
 * Desenvolvedor
 */
public class Developer {

    /**
     * Nome do desenvolvedor
     */
    private String nome;
    /**
     * Probabilidades das pontuações
     */
    private Map<String, Double> probabilidadePontos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Double> getProbabilidadePontos() {
        return probabilidadePontos;
    }

    public void setProbabilidadePontos(Map<String, Double> probabilidadePontos) {
        this.probabilidadePontos = probabilidadePontos;
    }

}
