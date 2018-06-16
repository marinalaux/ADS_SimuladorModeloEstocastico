package br.feevale.ads.simuladorestocastico.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Estatísticas
 */
public class Estatisticas {

    private Task minimum;
    private Task maximum;
    private double amplitude;
    private int numberOfClasses;
    private double intervalSize;
    private List<Interval> intervals;
    private List<Task> tasks;

    public Estatisticas(List<Task> tasks) {
        this.calculate(tasks);
    }

    public void calculate(List<Task> tasks) {
        this.tasks = tasks;
        generateExtremes();
        generateAmplitude();
        generateNumberOfClasses();
        generateIntervalSize();
        generateExtremesIntervals();
        generateFrequencyIntervals();
    }

    public Task getMinimum() {
        return minimum;
    }

    public void setMinimum(Task minimum) {
        this.minimum = minimum;
    }

    public Task getMaximum() {
        return maximum;
    }

    public void setMaximum(Task maximum) {
        this.maximum = maximum;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    private void generateExtremes() {
        this.minimum = tasks.get(0);
        this.maximum = tasks.get(0);
        for (Task task : tasks) {
            if (task.getTimeByPoint() < this.minimum.getTimeByPoint()) {
                this.minimum = task;
            }
            if (task.getTimeByPoint() > this.maximum.getTimeByPoint()) {
                this.maximum = task;
            }
        }
    }

    private void generateAmplitude() {
        this.amplitude = this.maximum.getTimeByPoint() - this.minimum.getTimeByPoint();
    }

    private void generateNumberOfClasses() {
        Double amplitude = Math.sqrt(this.amplitude);
        this.numberOfClasses = (int) Math.ceil(amplitude);
    }

    private void generateIntervalSize() {
        BigDecimal intervalSizeBigDecimal = new BigDecimal(this.amplitude / this.numberOfClasses);
        this.intervalSize = intervalSizeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private void generateExtremesIntervals() {
        this.intervals = new LinkedList<Interval>();
        for (int i = 0; i <= this.numberOfClasses; i++) {
            double startValue = minimum.getTimeByPoint() + (i * this.intervalSize);
            double endValue = (startValue + this.intervalSize) - 0.01;
            this.intervals.add(new Interval(startValue, endValue));
        }
        Interval lastInterval = intervals.get(intervals.size() - 1);
        lastInterval.setEndValue(lastInterval.getEndValue() + 0.01);
    }

    private void generateFrequencyIntervals() {
        for (Task task : tasks) {
            for (Interval interval : intervals) {
                if (isBetweenInterval(task, interval)) {
                    interval.addQuantity();
                    continue;
                }
            }
        }
    }

    private boolean isBetweenInterval(Task task, Interval interval) {
        return task.getTimeByPoint() >= interval.getStartValue() && task.getTimeByPoint() < interval.getEndValue();
    }
}
