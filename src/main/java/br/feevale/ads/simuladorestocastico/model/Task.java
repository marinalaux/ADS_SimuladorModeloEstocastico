package br.feevale.ads.simuladorestocastico.model;

/** 
 * Projeto....: SimuladorModeloEstocastico
 * Criado em..: 10/06/2018, 23:25:05 
 * Arquivo....: Task.java
 *
 * @author Pablo Oliveira (jntpablo)
 */
public class Task {
    private Integer points;
    private double time;

    public Task() {
    }

    public Task(Integer points, double time) {
        this.points = points;
        this.time = time;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    public double getTimeByPoint(){
        return time / points.doubleValue();
    }

}
