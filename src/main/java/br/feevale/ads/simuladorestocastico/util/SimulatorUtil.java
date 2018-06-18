package br.feevale.ads.simuladorestocastico.util;

import br.feevale.ads.simuladorestocastico.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;

/**
 * Utilitários do simulador
 */
public class SimulatorUtil {

    private static long getSampleValue(AbstractRealDistribution dist) {
        return Math.round(dist.sample());
    }

    public static List<Task> generateRandomTasks(int[] numsToGenerate, double[] discreteProbabilities, int quantityTaks,
            double mean, float minimo, float maximo) {
        List<Task> tasks = new ArrayList<>();
        JDKRandomGenerator random = new JDKRandomGenerator(1);
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(random, numsToGenerate, discreteProbabilities);
        ExponentialDistribution exp = new ExponentialDistribution(random, mean);
        int qtd = 0;
        while (qtd < quantityTaks) {
            int points = dist.sample();
            double time = getSampleValue(exp);
            if (time == 0 || time < minimo || time > maximo) {
                continue;
            }
            Task task = new Task();
            task.setPoints(points);
            task.setTime(time);
            tasks.add(task);
            qtd++;
        }
        return tasks;
    }

}
