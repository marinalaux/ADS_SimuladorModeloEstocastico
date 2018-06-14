package br.feevale.ads.simuladorestocastico.model;

/** 
 * Tarefa
 */
public class Task {
    
    /**
     * Pontos da tarefa
     */
    private Integer points;
    /**
     * Tempo investido na produção da tarefa
     */
    private double time;

    public Task() {}

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
