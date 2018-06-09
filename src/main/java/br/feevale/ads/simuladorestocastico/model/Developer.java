package br.feevale.ads.simuladorestocastico.model;

import java.util.HashMap;
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

    public Developer() {
        probabilidadePontos = new HashMap<>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Double> getProbabilidadePontos() {
        return new HashMap<>(probabilidadePontos);
    }

    public void setProbabilidadePontos(Map<String, Double> probabilidadePontos) {
        this.probabilidadePontos = probabilidadePontos;
    }
    
    public void changeProbabilidade(String key, Double value) {
        this.probabilidadePontos.put(key, value);
    }

}
