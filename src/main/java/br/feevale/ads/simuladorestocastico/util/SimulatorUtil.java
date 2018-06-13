package br.feevale.ads.simuladorestocastico.util;

import br.feevale.ads.simuladorestocastico.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;

/**
 * Utilitários do simulador
 */
public class SimulatorUtil {

    private static long getSampleValue(AbstractRealDistribution dist) {
        return Math.round(dist.sample());
    }

    public static List<Task> generateRandomTasks(int[] numsToGenerate, double[] discreteProbabilities, int quantityTaks, double mean) {
        List<Task> tasks = new ArrayList<>();
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(numsToGenerate, discreteProbabilities);
        ExponentialDistribution exp = new ExponentialDistribution(mean);
        for (int i = 0; i < quantityTaks; i++) {
            int points  = dist.sample();
            double time = getSampleValue(exp);
            Task task = new Task();
            task.setPoints(points);
            task.setTime(time);            
            tasks.add(task);
        }
        return tasks;
    }

}
