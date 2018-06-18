package br.feevale.ads.simuladorestocastico.model;

import br.feevale.ads.simuladorestocastico.util.SimulatorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    /**
     * Média de pontos
     */
    private float media;
    /**
     * Valor mínimo para tempo de produção
     */
    private int minimo;
    /**
     * Valor máximo para tempo de produção
     */
    private int maximo;
    /**
     * Quantidade de tarefas
     */
    private int quantityTaks;
    /**
     * Lista de tarefas
     */
    private List<Task> tasks;
    
    private Estatisticas estatisticas;

    public Developer() {
        this.probabilidadePontos = new HashMap<>();
        this.tasks = new ArrayList<>();
        this.quantityTaks = 0;
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

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Estatisticas getEstatisticas() {
        return estatisticas;
    }
    
    public void changeQuantityTasks(int newQuantity) {
        this.quantityTaks = newQuantity;
    }

    public void changeProbabilidade(String key, Double value) {
        this.probabilidadePontos.put(key, value);
    }

    public int getQuantityTaks() {
        return quantityTaks;
    }

    public void setQuantityTaks(int quantityTaks) {
        this.quantityTaks = quantityTaks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public double getTimeAverage() {
        double timeByPointAllTasks = tasks.stream()
                .mapToDouble(Task::getTimeByPoint)
                .sum();
        Integer quantityOfTasks = tasks.size();
        return timeByPointAllTasks / quantityOfTasks.doubleValue();
    }

    public void simulate() {
//        System.out.println("Simulando...");
        int[] numsToGenerate = getNumsToGenerate();
        double[] discreteProbabilities = getDiscreteProbabilities();
        this.tasks = SimulatorUtil.generateRandomTasks(numsToGenerate, discreteProbabilities,
                this.quantityTaks, this.media, this.minimo, this.maximo);
        this.estatisticas = new Estatisticas(this.tasks);
//        for (Task task : this.tasks) { // TODO: Remover sysout
//            System.out.println("Pontos....: " + task.getPoints() + " -> Tempo....:" + task.getTime()); 
//        }
    }

    private int[] getNumsToGenerate() {
        int[] numsInt = new int[0];
        for (String num : this.probabilidadePontos.keySet()) {
            numsInt = addIntElement(numsInt, Integer.valueOf(num));
        }
        return numsInt;
    }

    private double[] getDiscreteProbabilities() {
        double[] numsDouble = new double[0];
        for (String num : this.probabilidadePontos.keySet()) {
            numsDouble = addDoubleElement(numsDouble, this.probabilidadePontos.get(num));
        }
        return numsDouble;
    }

    private int[] addIntElement(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    private double[] addDoubleElement(double[] a, double e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String prob : probabilidadePontos.keySet()) {
            sb.append(prob + " = " + probabilidadePontos.get(prob));
            sb.append("\n");
        }
        return sb.toString();
    }
}
