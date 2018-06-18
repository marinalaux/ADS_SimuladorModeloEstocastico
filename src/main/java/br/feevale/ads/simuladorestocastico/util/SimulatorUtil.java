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
            double mean, int minimo, int maximo) {
        List<Task> tasks = new ArrayList<>();
        EnumeratedIntegerDistribution dist = new EnumeratedIntegerDistribution(new JDKRandomGenerator(1), numsToGenerate, discreteProbabilities);
        ExponentialDistribution exp = new ExponentialDistribution(new JDKRandomGenerator(minimo), mean);
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
