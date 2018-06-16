package br.feevale.ads.simuladorestocastico.model;

/** 
 * Intervalo de frequências
 */
public class Interval {
    
    private double startValue;
    private double endValue;
    private int quantityValues;

    public Interval(double startValue, double endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.quantityValues = 0;
    }

    public Interval(double startValue, double endValue, int quantityValues) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.quantityValues = quantityValues;
    }

    public double getStartValue() {
        return startValue;
    }

    public void setStartValue(double startValue) {
        this.startValue = startValue;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public int getQuantityValues() {
        return quantityValues;
    }
    
    public void addQuantity(){
        this.quantityValues++;
    }
}
