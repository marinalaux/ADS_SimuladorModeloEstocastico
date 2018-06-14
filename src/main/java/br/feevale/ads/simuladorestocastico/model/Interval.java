/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.feevale.ads.simuladorestocastico.model;

/** 
 * Projeto....: SimuladorModeloEstocastico
 * Criado em..: 13/06/2018, 21:08:45 
 * Arquivo....: Interval.java
 *
 * @author Pablo Oliveira (jntpablo)
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
